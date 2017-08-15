package com.example.demo.threadtest.wait;

import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lenovo on 2017/8/9.
 */

/**
 * 原子类
 */
public class waitNoy extends Thread{

      static AtomicInteger ai=new AtomicInteger(0);
     // static int ai = 0 ;

    public void run() {
        for (int m = 0; m < 1000000; m++) {
             ai.getAndIncrement();
          //  ai++ ;
        }
    }



    public static void main(String[] args) throws InterruptedException {
//        waitNoy mt = new waitNoy();
//
//        Thread t1 = new Thread(mt);
//        Thread t2 = new Thread(mt);
//        t1.start();
//        t2.start();
//        Thread.sleep(500);
//        System.out.println(waitNoy.ai.get());
    //   System.out.println(waitNoy.ai );


        String str= "SZZZCWZ81610102658\",\"contractId\":17645,\"type\":5}" ;
        String sb = str.split("\"")[0];
        System.out.println(sb);
    }


}
