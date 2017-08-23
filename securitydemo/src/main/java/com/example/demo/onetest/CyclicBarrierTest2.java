package com.example.demo.onetest;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by lenovo on 2017/8/23.
 */
public class CyclicBarrierTest2 {

    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    c.await();

                    System.out.println(Thread.currentThread().getName());
                 } catch (Exception e) {

                }
                System.out.println(1);
            }
        }).start();

        try {
            int i = c.await();
            System.out.println(111111+i);
        } catch (Exception e) {

        }
        System.out.println(2);
    }
}
