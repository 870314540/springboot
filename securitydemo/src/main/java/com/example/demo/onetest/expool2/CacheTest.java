package com.example.demo.onetest.expool2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lenovo on 2017/8/25.
 */
public class CacheTest {

    public static void main(String[] args) {

        //创建一个可重用固定线程数的线程池

        ExecutorService pool = Executors.newCachedThreadPool();

        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口

        Thread t1 = new Thread1();

        Thread t2 = new Thread1();

        Thread t3 = new Thread1();

        Thread t4 = new Thread1();

        Thread t5 = new Thread1();

        //将线程放入池中进行执行

        pool.execute(t1);

        pool.execute(t2);

        pool.execute(t3);

        pool.execute(t4);

        pool.execute(t5);

        //关闭线程池

        pool.shutdown();

    }
}
