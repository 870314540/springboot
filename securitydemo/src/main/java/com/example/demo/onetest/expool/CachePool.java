package com.example.demo.onetest.expool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lenovo on 2017/8/24.
 */
public class CachePool {
public static  void main(String[] args){

    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    for (int i = 0; i < 1000000; i++) {
        final int index = i;
//        try {
//            Thread.sleep( 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        cachedThreadPool.execute(new Runnable() {
            public void run() {
                long sum = 0L;
                for(int i = 1 ; i < 10000 ; i++){
                    sum += i ;
                }
                System.out.println(index + "sum :"+ sum);
             }
        });
    }
}
}
