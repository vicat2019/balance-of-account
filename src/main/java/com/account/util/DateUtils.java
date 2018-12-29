package com.account.util;

import org.thymeleaf.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: balance-of-account
 * @description: 日期工具
 * @author: Vincent
 * @create: 2018-12-28 11:46
 **/
public class DateUtils {

    /**
     * 格式化日志
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format) {
        if (date == null) {
            date = new Date();
        }
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }




}
