package com.sugar.test.concurrentPage;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.LockSupport;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/3/25
 */
public class Test1 {

    public static void main(String[] args){
        CountDownLatch countDownLanch = new CountDownLatch(1);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1);

        LockSupport lockSupport ;


        HashMap hashMap = Maps.newHashMap();
        hashMap.put("1",null);
        hashMap.put("1","111");

        System.out.println(hashMap);


    }
}
