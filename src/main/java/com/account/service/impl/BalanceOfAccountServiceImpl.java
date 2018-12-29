package com.account.service.impl;

import com.account.dao.base.AccountDataInfoMapper;
import com.account.entity.AccountDataInfo;
import com.account.entity.RpTradePaymentRecord;
import com.account.entity.base.ResultData;
import com.account.service.BalanceOfAccountService;
import com.account.service.BaseService;
import com.account.service.RpTradePaymentQueryService;
import com.account.util.ExcelUtils;
import com.account.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: balance-of-account
 * @description: 对账服务类
 * @author: Vincent
 * @create: 2018-12-27 18:14
 **/
@Service("balanceOfAccountService")
public class BalanceOfAccountServiceImpl extends BaseService<AccountDataInfoMapper, AccountDataInfo> implements BalanceOfAccountService {
    private Logger log = LoggerFactory.getLogger("BalanceOfAccountServiceImpl");

    @Value("${upload.path}")
    private String UPLOAD_FOLDER_PATH;

    @Autowired
    private RpTradePaymentQueryService rpTradePaymentQueryService;

    // 文件后缀名
    private final String[] FILE_EXTENSIONS = {"xlsx", "xls", "zip"};


    @Override
    public ResultData uploadDataFile(MultipartFile file, HttpServletRequest request) throws Exception {
        // 检查文件
        if (file == null) {
            return ResultData.getErrResult("上传文件为空");
        }
        String sourceFilePath = file.getOriginalFilename();

        // 处理上传文件
        ResultData uploadResult = handleUploadFile(file);
        if (!uploadResult.isOk() || uploadResult.resultIsEmpty()) {
            return uploadResult;
        }
        log.info("----------完成上传文件处理操作------------------------------------------");

        // 获取文件列表
        List<File> uploadFileList = (List<File>) uploadResult.getData();
        uploadFileList.forEach(item -> {
            try {
                // 解析数据
                String filePath = item.getPath();
                // 读取文件数据
                List<AccountDataInfo> fileDataList = readData(filePath, sourceFilePath);

                if (fileDataList == null || fileDataList.size() == 0) {
                    log.error("文件[" + filePath + "]内容为空");
                } else {
                    // 保存到源数据表
                    int srcCount = mapper.insertBatchToSrc(fileDataList);
                    log.info("文件[" + filePath + "]导入数据到源数据表，个数=" + srcCount);
                    // 将数据保存到数据库中
                    int count = mapper.insertBatch(fileDataList);
                    log.info("文件[" + filePath + "]添加到去重表个数=" + count);
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error("读取文件[" + item.getPath() + "]异常=" + e.getMessage());
            }
        });
        log.info("----------完成文件数据入库操作------------------------------------------");

        // 获取数据中的交易日
        List<String> billDateList = mapper.getBillDateByFileName(sourceFilePath);

        billDateList.forEach(billDate -> {
            // 查询平台中某交易日的订单银行编号
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("status", "SUCCESS");
            paramMap.put("billDate", billDate);
            List<String> platformNoList = rpTradePaymentQueryService.listBandOrderNoByColumn(paramMap);

            // 查询入库的账单数据
            List<AccountDataInfo> accountDataList = mapper.queryByDate(billDate);
            List<String> accountNoList = new ArrayList<>();
            if (accountDataList != null && accountDataList.size() > 0) {
                accountDataList.forEach(item -> {
                    if (item.getOrderCode().contains("-")) {
                        accountNoList.add(item.getRealOrderNo());
                    } else {
                        accountNoList.add(item.getOrderCode());
                    }
                });
            } else {
                accountDataList = new ArrayList<>();
            }

            // 以支付宝账单为准
            List<AccountDataInfo> baseOnFileList = accountDataList.stream().filter(accountDataInfo ->
                    !platformNoList.contains(accountDataInfo.getOrderCode()) && !platformNoList.contains(accountDataInfo.getRealOrderNo())
            ).collect(Collectors.toList());
            if (baseOnFileList.size() > 0) {
                mapper.insertBatchMismatch(baseOnFileList);
            }

            // 以平台为准
            List<String> baseOnPlatformList = platformNoList.stream().filter(s ->
                    !accountNoList.contains(s)
            ).collect(Collectors.toList());
            if (baseOnPlatformList.size() > 0) {
                handleBaseOnPlatformData(baseOnPlatformList);
            }
        });
        log.info("----------完成对账操作--------------------------------------------------");

        return ResultData.getSuccessResult();
    }

    /**
     * 处理基于平台数据对账后的账单数据集合
     *
     * @param baseOnPlatformList 数据集合
     */
    private void handleBaseOnPlatformData(List<String> baseOnPlatformList) {
        // 数量小于1000，直接查询添加
        if (baseOnPlatformList.size() < 1000) {
            List<RpTradePaymentRecord> tradeList = rpTradePaymentQueryService.queryByBankOrderNo(baseOnPlatformList);
            if (tradeList != null && tradeList.size() > 0) {
                rpTradePaymentQueryService.insertBatchMismatch(tradeList);
            }

        } else {
            // 数量大于1000，分页查询添加
            int size = baseOnPlatformList.size();
            int page = (size % 1000 == 0) ? (size / 1000) : (size / 1000 + 1);

            for (int i = 1; i <= page; i++) {
                // 计算数据索引
                int startIndex;
                int endIndex;
                if (i == 1) {
                    startIndex = 0;
                    endIndex = i * 1000;
                } else if (i == page) {
                    startIndex = (i - 1) * 1000;
                    endIndex = size;
                } else {
                    startIndex = (i - 1) * 1000;
                    endIndex = i * 1000;
                }

                // 查询分页数据
                List<RpTradePaymentRecord> tradeList = rpTradePaymentQueryService.queryByBankOrderNo(
                        baseOnPlatformList.subList(startIndex, endIndex));
                log.info("查询" + startIndex + "到" + endIndex + "的数据, 个数=" + (tradeList == null ? 0 : tradeList.size()));

                // 不为空，保存数据
                if (tradeList != null && tradeList.size() > 0) {
                    rpTradePaymentQueryService.insertBatchMismatch(tradeList);
                }
            }
        }
    }

    /**
     * 处理上传文件
     *
     * @param file 上传的文件
     * @return ResultData
     */
    private ResultData handleUploadFile(MultipartFile file) {
        // 上传文件
        ResultData<String> uploadResult = uploadFile(file);
        if (!uploadResult.isOk()) {
            return uploadResult;
        }
        String filePath = uploadResult.getData();
        if (StringUtils.isEmpty(filePath)) {
            return ResultData.getErrResult("上传文件异常，文件地址为空");
        }

        // 上传文件列表
        List<File> dataFileList = new ArrayList<>();

        // 如果是压缩包
        if (!StringUtils.isEmpty(file.getOriginalFilename()) && isZipFile(file.getOriginalFilename())) {
            // 解压
            String unzipFolderPath = FileUtils.unzipFile(filePath);
            if (StringUtils.isEmpty(unzipFolderPath)) {
                return ResultData.getErrResult("返回的解压后的文件目录为空");
            }

            // 遍历文件
            File unzipFolder = new File(unzipFolderPath);
            if (!unzipFolder.exists()) {
                return ResultData.getErrResult("解压后的目录文件不存在[" + unzipFolderPath + "]");
            }
            File[] fileAr = unzipFolder.listFiles();
            if (fileAr == null) {
                return ResultData.getErrResult("获取文件列表异常");
            }
            for (File item : fileAr) {
                if (item.isFile()) {
                    dataFileList.add(item);
                    continue;
                }
                File[] tempAr = item.listFiles();
                if (tempAr != null && tempAr.length > 0) dataFileList.addAll(Arrays.asList(tempAr));
            }
        } else {
            dataFileList.add(new File(filePath));
        }
        log.info("处理后上传的文件个数=" + dataFileList.size());

        return ResultData.getSuccessResult(dataFileList);
    }

    /**
     * 是否是压缩文件
     *
     * @param filePath
     * @return
     */
    private boolean isZipFile(String filePath) {
        int index = filePath.lastIndexOf(".");
        if (index > 0) {
            String extension = filePath.substring(index + 1);
            return "zip".equals(extension.trim().toLowerCase());
        }

        return false;
    }

    /**
     * 处理上传文件
     *
     * @param uploadFile 上传的文件
     * @return ResultData
     */
    private ResultData<String> uploadFile(MultipartFile uploadFile) {
        // 获取扩展名称
        String originalFileName = uploadFile.getOriginalFilename();
        if (StringUtils.isEmpty(originalFileName)) {
            return ResultData.getErrResult("获取上传文件名称失败");
        }
        Integer index = originalFileName.lastIndexOf(".");
        if (index < 0) {
            return ResultData.getErrResult("文件类型异常");
        }
        // 检查文件类型
        String extension = originalFileName.substring(index + 1);
        if (!isContainExtension(extension)) {
            return ResultData.getErrResult("文件类型[" + extension + "]异常");
        }

        // 重新生成唯一文件名
        String newFileName = UUID.randomUUID().toString() + "." + extension;
        log.info("上传文件，原始名称= " + originalFileName + ", 新名称=" + newFileName);

        // 检查路径是否存在，不存在，则创建
        File folder = new File(UPLOAD_FOLDER_PATH);
        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                return ResultData.getErrResult("创建上传文件目录失败");
            }
            log.info("创建目录=" + UPLOAD_FOLDER_PATH);
        }

        // 创建文件
        File destFile = new File(UPLOAD_FOLDER_PATH + File.separator + newFileName);
        try {
            uploadFile.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("上传数据文件，异常=" + e.getMessage());
        }

        // 返回上传后的文件名称
        ResultData<String> result = ResultData.getSuccessResult();
        result.setData(destFile.getPath());
        return result;
    }

    /**
     * 是否是包含该扩展
     *
     * @param extension
     * @return
     */
    private boolean isContainExtension(String extension) {
        for (String item : FILE_EXTENSIONS) {
            if (item.equals(extension.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 读取数据
     *
     * @param filePath       文件路径
     * @param sourceFileName 源文件名称
     * @return List
     * @throws Exception 异常
     */
    private List<AccountDataInfo> readData(String filePath, String sourceFileName) throws Exception {
        List<AccountDataInfo> dataList = new ArrayList<>();

        // 读取文件
        List<Object> fileDataList = ExcelUtils.readExcel(filePath, -1, 4, "ALL");
        log.info("从数据文件[" + filePath + "]中读取的记录数=" + fileDataList.size());

        // 遍历数据，转换成对象
        fileDataList.forEach(item -> {
            AccountDataInfo temp = AccountDataInfo.fromListData((List<Object>) item, sourceFileName);
            if (temp != null && !temp.isEmpty() && temp.isTransfer()) {
                dataList.add(temp);
            }
        });
        return dataList;
    }


}
