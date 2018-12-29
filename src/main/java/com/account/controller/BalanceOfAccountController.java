package com.account.controller;

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
    private RpTradePaymentQueryService rpTradePaymentQueryService;


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

    @RequestMapping("/test")
    public String test(ModelMap modelMap) {
        modelMap.addAttribute("uploadFile", "123.xlsx");
        modelMap.addAttribute("dataCount", 236);
        modelMap.addAttribute("fileRemainCount", 152);
        modelMap.addAttribute("platformRemainCount", 11);

        return "result";
    }


}
