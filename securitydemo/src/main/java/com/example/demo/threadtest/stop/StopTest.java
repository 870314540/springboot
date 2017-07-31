package com.example.demo.threadtest.stop;

/**
 * Created by sugar on 17-7-30.
 */
public class StopTest {
    public static  void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread1("t1");

        t1.start();
        Thread.sleep(100);
        t1.stop();
        //stop 已被弃用
    }
}
