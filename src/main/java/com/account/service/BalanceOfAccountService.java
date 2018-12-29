package com.account.service;

import com.account.entity.base.ResultData;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 对账服务接口
 * @Author: Vincent
 * @Date: 2018/12/29
 */
public interface BalanceOfAccountService {

    /**
     * 上传数据文件
     *
     * @param file    上传的文件
     * @param request 请求
     * @return ResultData
     * @throws Exception 异常
     */
    ResultData uploadDataFile(MultipartFile file, HttpServletRequest request) throws Exception;


}
