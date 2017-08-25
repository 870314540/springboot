package com.example.demo.onetest.expool2;

/**
 * Created by lenovo on 2017/8/25.
 */
public class Thread1 extends Thread {

    @Override

    public void run() {

        System.out.println(Thread.currentThread().getName() + "正在执行。。。");

    }

}
