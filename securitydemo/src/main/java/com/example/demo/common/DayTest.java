package com.example.demo.common;


import java.util.ArrayList;
import java.util.List;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/12/13
 */
public class DayTest {
    public static void main(String[] args) {
        //1 验证list为空，for循环是否报异常
        List<String> list = new ArrayList<String>();
        for (String var : list) {
            System.out.println("var" + var);
        }
        System.out.println("=============");
        list.add("111");
        for (String var : list) {
            System.out.println("var1" + var);
        }
    }
}
