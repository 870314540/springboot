package com.example.demo.test.test1;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/7/29
 */
public class StringTest {
    /**
     * 证件号掩码
     */
    public static String convertIdCard(String idCard) {
        if (idCard.length() < 5) {
            return idCard;
        }
        String frommark = idCard.substring(2, idCard.length() - 2);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= frommark.length(); i++) {
            sb.append("*");
        }
        String tomark = frommark.replaceAll("\\d+", sb.toString());

        return idCard.substring(0, 2) + tomark + idCard.substring(idCard.length() - 2, idCard.length());
    }


    /**
     * 得到几天前的时间
     */
    public static Date getDateBefore(Date inDate, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(inDate);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    public static Date getdate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date result = format.parse(date);
            return result;
        } catch (Exception e) {

        }
        return null;

    }

    public static void ListSort(List<DayBO> list) {
        Collections.sort(list, new Comparator<DayBO>() {
            @Override
            public int compare(DayBO o1, DayBO o2) {
                try {
                    if (o1.getDate().getTime() > o2.getDate().getTime()) {
                        return 1;
                    } else if (o1.getDate().getTime() < o2.getDate().getTime()) {
                        return -1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }

    public static void main(String[] args) {
//        Map<String, String> resultMap = new HashMap<String, String>();
//        String s1 = "2";
//        String appIds[] = new String[2];
//        appIds[1] = "1";
//        appIds[0] = s1;
//        //数组拼的字符串
//        String s2 = "[0," + s1 + "]";
//        resultMap.put("m1", JSON.toJSONString(appIds));
//        resultMap.put("m2", s2);
//
//        System.out.println(JSON.toJSONString(resultMap));
//
//        //Long to String
//        Long resutl1 = 888469301135142918L;
//        System.out.println(resutl1.toString());
//
//        //set map contains
//        Map<String, Integer> resultMap1 = new LinkedHashMap<>();
//        System.out.println(resultMap1.get("321"));
//
//        Set<String> nullSet = new HashSet<>();
//
//        System.out.println(nullSet.contains("321"));
//
//        //正则匹配：斜线的问题
//        UserEntity entity = new UserEntity();
//        entity.setUserName("焦作/济源");
//        entity.setUserAge(19);
//        System.out.println(JSON.toJSONString(entity));
//
//        String name = entity.getUserName();
//        System.out.println(name);
//        if (name.contains("/")) {
//            name = name.split("\\/")[0];
//        }
//        System.out.println(name);
//
//        String cityName = "黄";
//        System.out.println(cityName.length());
//
//        String city = "11 ";
//        //        city = city.trim();
//        System.out.println(city);


//        System.out.println(convertIdCard("12090"));


//
//        Calendar ncalendar = Calendar.getInstance();
////小时
//        System.out.println(ncalendar.get(Calendar.HOUR_OF_DAY));
////分
//        System.out.println(ncalendar.get(Calendar.MINUTE));
//        String key = "C002002001";
//        System.out.println(key.substring(0, 10));
//        System.out.println(key.length());
//        String str1 = null;
//        str1 = "," + "";
//        if (str1==",") {
//            System.out.println(1111);
//
//        }
//        System.out.println(str1);
//        List<String> list = new ArrayList();
////        list.add("111");
//        for(String i : list){
//            System.out.println(i);
//        }
//        String busiType = "[1,2]" ;
//
//        System.out.println(busiType);
//
//        Map<String,String>  map = new HashMap<>();
//        map.put("busiType",busiType);
//
//        System.out.println(JSON.toJSONString(map));


//        System.out.println(new BigDecimal("0.4").setScale(0, BigDecimal.ROUND_DOWN));
//
////        System.out.println(getDateBefore(new Date(),-1));
//
//        List<DayBO> list = new ArrayList<>();
//
//        DayBO dayBO = new DayBO();
//
//        dayBO.setId(1);
//        dayBO.setDate(getdate("2018-01-01 00:00:00"));
//
//        list.add(dayBO);
//
//        DayBO dayBO1 = new DayBO();
//
//        dayBO1.setId(2);
//        dayBO1.setDate(getdate("2018-01-01 00:01:01"));
//
//        list.add(dayBO1);
//
//        DayBO dayBO2 = new DayBO();
//
//        dayBO2.setId(4);
//        dayBO2.setDate(getdate("2018-01-01 00:00:01"));
//
//        list.add(dayBO2);
//
//
//        DayBO dayBO4 = new DayBO();
//
//        dayBO4.setId(5);
//        dayBO4.setDate(getdate("2018-01-01 10:00:00"));
//
//        list.add(dayBO4);
//
//
//        System.out.println(JSON.toJSONString(list));
//        ListSort(list);
//        System.out.println(JSON.toJSONString(list));


        String top = "T_TOPIC";
        String tag = "P_LOAN";

        if(!top.equals("T_TOPIC") || !tag.equals("P_LOAN")){
            System.out.println(111);
        }





    }


}
