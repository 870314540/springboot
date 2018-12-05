package com.example.demo.onetest;

import java.util.concurrent.Phaser;

/**
 * @author thomas
 * @Descrption
 * @create 2018/12/5
 */
public class PhaserTest implements Runnable {
    private final Phaser phaser;

    public PhaserTest(Phaser phaser) {
        this.phaser = phaser;
    }

    //Phaser这个类主要是针对于多阶段注册的任务的多线程工具类.
    //以下是个人理解,没看API源码.
    //顾名思义这个类中会存在类似的两个变量来控制注册和阶段.

    //注册步骤(parties)一般情况下可理解为线程.
    //可以通过arrive()/arriveAndAwaitAdvance()/arriveAndDeregister()推进每个已注册步骤的完成.
    //可以在初始化Phaser时候指定,并且采用register()/bulkRegister(int parties)方法来注册增加步骤.
    //为了让已注册步骤不参与下一阶段的操作可采用arriveAndDeregister().
    //特殊情况下注册步骤不可理解为线程.比如当某个线程调用两次arrive()那么相当于推进两次注册步骤.

    //Phaser.getPhase()用于获取当前的阶段.默认阶段从0开始.
    //当某个阶段所有的注册步骤都完成的时候.阶段值会自动增加1.
    //Phaser存在一个awaitAdvance(int phase)方法.如果形参等于Phaser.getPhase()即当前阶段,那么等待.直到phase改变的时候这个方法继续执行.

    /*
     *以下是一些对应的解释代码.
     *假设一个情景:一项任务分为三个阶段(phase = 3),每个阶段有4个注册步骤.
     */

    public static void main(String[] args) {
        int parties = 4;//四个步骤
        Phaser phaser = new Phaser(parties);
        Thread[] threads = new Thread[parties];
        for (int i = 0; i < parties; i++) {
            threads[i] = new Thread(new PhaserTest(phaser));
        }

        try {
            for (int i = 0; i < parties; i++) {
                threads[i].join();
                threads[i].start();
            }
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //isTerminated()：判断Phaser是否终止。
        System.out.println(phaser.isTerminated());

    }

    @Override
    public void run() {
        first();
        second();
        third();
    }

    public void first() {
        System.out.println(Thread.currentThread().getName() + ":first.");
        //arriveAndAwaitAdvance。这个方法会等到下一个phase开始再返回，相等于doArrive方法添加了awaitAdvance方法的功能
        phaser.arriveAndAwaitAdvance();
    }

    public void second() {
        System.out.println(Thread.currentThread().getName() + ":second.");
        phaser.arriveAndAwaitAdvance();
    }

    public void third() {
        System.out.println(Thread.currentThread().getName() + ":third.");
        //arriveAndDeregister()：把执行到此的线程从Phaser中注销掉。
        phaser.arriveAndDeregister();
    }


}


