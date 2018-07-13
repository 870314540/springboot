package com.example.demo.onetest.collection;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/6/27
 */
public class ColTest {

    public static void main(String[] args){
        Set<String> set1 = new HashSet<>();

        set1.add("1");
        set1.add("2");
        set1.add("3");
        set1.add("4");
        set1.add("6");
        set1.add("2");

        List<String> list1 = new LinkedList<>();
        list1.add("1");
        list1.add("10");
        list1.add("11");
        list1.add("2");

        set1.addAll(list1);

        System.out.println(set1.size());
    }
}
