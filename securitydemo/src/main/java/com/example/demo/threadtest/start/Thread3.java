package com.example.demo.threadtest.start;

/**
 * Created by lenovo on 2017/8/9.
 */

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现 Runnable接口
 */
public class Thread3 implements Runnable{
    private  String name ;


    public Thread3(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0 ; i< 100 ;i++){
            System.out.println(i);
            try{
                Thread.sleep((int)Math.random()*100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] at){
        Object ob = new Object();
        int j = 0;
        AtomicInteger i = new AtomicInteger(1);
        Thread tt = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ob){

                    while(i.intValue() < 10){
                        System.out.println(Thread.currentThread().getName()+":"+i.intValue());
                        if (i.intValue() == 5){
                            ob.notify(); //并不释放锁
                            System.out.println("");
                        }
                        i.incrementAndGet();
                    }

                }
            }
        });
        Thread tr = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ob){
                    try {
                        System.out.println("11111");
                        ob.wait();
                        System.out.println("22222");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ob){
                    try {
                        System.out.println("333333");
                        ob.wait();
                        System.out.println("444444");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        tt.start();
        tr.start();
        t3.start();
    }




}
