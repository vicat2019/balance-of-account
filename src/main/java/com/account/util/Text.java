package com.account.util;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: balance-of-account
 * @description: Test
 * @author: Vincent
 * @create: 2018-12-28 16:18
 **/
public class Text {

    public static void main(String arge[]) {

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);

        System.out.println(a.subList(0, 1));
        System.out.println(a.subList(0, 3));
        System.out.println(a.subList(1, a.size()));
    }
}
