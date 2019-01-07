package com.example.demo.common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/12/13
 */
class DayTest {


    private static String convert2String(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer || obj instanceof Long) {
            return obj + "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj.toString();
    }

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


        float d = 365 * 5 / ((float) 400 * 2) * 100;

        System.out.println(d);


        Integer number1 = 1;

        System.out.println(convert2String(number1));

        TestB b = new TestB();
        b.setA(1);
        b.setB(2);
        TestA a = JSON.parseObject(JSON.toJSONString(b), TestA.class);

        System.out.println(a.toString());


        TestA aa = new TestA();
        aa.setA(3);
        TestB ba = JSON.parseObject(JSON.toJSONString(aa), TestB.class);
        System.out.println(ba.toString());

    }
}
