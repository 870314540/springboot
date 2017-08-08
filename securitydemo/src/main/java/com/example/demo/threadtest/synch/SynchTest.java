package com.example.demo.threadtest.synch;

import com.example.demo.threadtest.start.Thread1;

/**
 * Created by lenovo on 2017/7/31.
 */
public class SynchTest extends  Thread{

   // private int count = 1 ;
   // private volatile int count = 1 ;
   private static int count = 1 ;
    //public   synchronized void run(){
//        count++;
//        System.out.println(this.currentThread().getName()+" "+ count);
//    }
    public     void run(){
        count++;
        System.out.println(this.currentThread().getName()+" "+ count);
    }
    public static  void main(String[] args){
        SynchTest m = new SynchTest();
//        Thread t1 = new Thread(m,"t1");
//        Thread t2 = new Thread(m,"t2");
//        Thread t3 = new Thread(m,"t3");
//        Thread t4 = new Thread(m,"t4");
        Thread t1 = new Thread(new SynchTest(),"t1");
        Thread t2 = new Thread(new SynchTest(),"t2");
        Thread t3 = new Thread(new SynchTest(),"t3");
        Thread t4 = new Thread(new SynchTest(),"t4");


        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}
