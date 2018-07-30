package com.example.demo.test.test1;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/7/29
 */
public class StringTest {
    public static void main(String[] args) {
        Map<String,String> resultMap = new HashMap<String,String>();
        String s1 = "2" ;
        String appIds[] = new String[2];
        appIds[1] = "1";
        appIds[0] = s1;



        String s2 = "[0,"+s1+"]";
        resultMap.put("m1",JSON.toJSONString(appIds));
        resultMap.put("m2",s2);

        System.out.println(JSON.toJSONString(resultMap));


        Long resutl1 = 888469301135142918L;
        System.out.println(resutl1.toString());


        Map<String,Integer> resultMap1 = new LinkedHashMap<>();
        System.out.println(resultMap1.get("321"));

        Set<String> nullSet = new HashSet<>();

        System.out.println(nullSet.contains("321"));



    }
}
