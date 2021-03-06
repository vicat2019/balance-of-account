package com.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: balance-of-account
 * @description: 主类
 * @author: Vincent
 * @create: 2018-12-27 18:36
 **/
@SpringBootApplication
//@ComponentScan(basePackages = {"com.account"})
//@MapperScan("com.account.dao.base")
public class BoaApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoaApplication.class, args);
    }
}
