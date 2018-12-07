package com.example.demo.threadtest.wait;

import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lenovo on 2017/8/9.
 */

/**
 * 原子类
 */
public class waitNoy extends Thread {

    static AtomicInteger ai = new AtomicInteger(0);
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
        int q = 655555;
        System.out.println((q << 6) + (q << 5) + (q << 2));
        while (true) {
            for (int i = 0; i < 100; i++) {
                if (i == 10) break;
            }
            System.out.println(111);
        }
    }


}
