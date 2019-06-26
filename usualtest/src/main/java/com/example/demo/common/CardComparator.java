package com.example.demo.common;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/4/24
 */
public class CardComparator implements Comparator<CardVO> {

    @Override
    public int compare(CardVO o1, CardVO o2) {
        if (o1.getSortCode().intValue() < o2.getSortCode().intValue()) {
            return -1;
        }
        return 0;
    }


    public static void main(String[] args) {
//        List<CardVO> voList = new ArrayList<>();
//
//        for (int i = 0; i < 8; i++) {
//            CardVO vo = new CardVO("q" + i, i);
//            voList.add(vo);
//        }
//
//        for (int j = 0; j < 8; j++) {
//            CardVO vo = new CardVO("qq" + j, j);
//            voList.add(vo);
//        }
//
//
//        for (int j = 0; j < 8; j++) {
//            CardVO vo = new CardVO("qqq" + j, j);
//            voList.add(vo);
//        }
//        CardComparator cardComparator = new CardComparator();
//        Ordering ordering = Ordering.from(cardComparator);
//        Collections.sort(voList,ordering);
//
//        System.out.println(JSON.toJSONString(voList));




        long i = 24L * 1000 * 1000 * 60 * 60 ;

        System.out.println(i);
        System.out.println(Integer.MAX_VALUE);


    }



}
