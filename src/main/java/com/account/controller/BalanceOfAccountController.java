package com.account.controller;

import com.account.dao.base.AccountDataInfoMapper;
import com.account.dao.other.UserInfoOneMapper;
import com.account.entity.AccountDataInfo;
import com.account.entity.UserInfo;
import com.account.entity.base.ResultData;
import com.account.service.BalanceOfAccountService;
import com.account.service.RpTradePaymentQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: balance-of-account
 * @description: 对账控制类
 * @author: Vincent
 * @create: 2018-12-27 18:23
 **/
@Controller
public class BalanceOfAccountController {

    @Autowired
    private BalanceOfAccountService balanceOfAccountService;

    @Autowired
    private AccountDataInfoMapper accountDataInfoMapper;

    @Autowired
    private RpTradePaymentQueryService rpTradePaymentQueryService;

    @Autowired
    private UserInfoOneMapper userInfoOneMapper;



    @RequestMapping("/")
    public String uploadPage() {
        return "index";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public ResultData upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        try {
            return balanceOfAccountService.uploadDataFile(file, request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultData.getErrResult();
    }


    @RequestMapping("/mdb")
    @ResponseBody
    public ResultData testMultiDb() {
        List<String> dataList = accountDataInfoMapper.test();
        if (dataList!=null) {
            dataList.forEach(System.out::println);
        }

        System.out.println("--------------------------------------------------------------------------");

        List<UserInfo> userList = userInfoOneMapper.selectAll();
        if (userList != null) {
            userList.forEach(System.out::println);
        }

        return ResultData.getSuccessResult();
    }





















    @RequestMapping("/test")
    public String test(ModelMap modelMap) {
        modelMap.addAttribute("uploadFile", "123.xlsx");
        modelMap.addAttribute("dataCount", 236);
        modelMap.addAttribute("fileRemainCount", 152);
        modelMap.addAttribute("platformRemainCount", 11);

/*        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLessThan("age", 20);*/


        //List<UserInfo> userList = userInfoOneMapper.selectByExample(example);

        List<AccountDataInfo> list = accountDataInfoMapper.queryByDate("2018-12-24");
        System.out.println(list.size());

        //modelMap.addAttribute("users", userList);
        return "result";
    }


}
