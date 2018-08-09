package com.example.demo.threadtest.pool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/8/9
 */
public class ThreadPool1 {



    public void threadPool(){

        /*java提供的统计线程运行数，一开始设置其值为50000，每一个线程任务执行完
         * 调用CountDownLatch#coutDown()方法（其实就是自减1）
         * 当所有的线程都执行完其值就为0
         */
        CountDownLatch count = new CountDownLatch(50000);
        long start = System.currentTimeMillis();
        Executor pool = Executors.newFixedThreadPool(10);//开启线程池最多会创建10个线程
        for(int i=0;i<50000;i++){
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello");
                    count.countDown();
                }
            });
        }

        while(count.getCount()!=0){//堵塞等待5w个线程运行完毕

        }
        long end = System.currentTimeMillis();
        System.out.println("50个线程都执行完了,共用时:"+(end-start)+"ms");
    }



    public void thread(){
        CountDownLatch count = new CountDownLatch(50000);
        long start = System.currentTimeMillis();
        for(int i=0;i<50000;i++){
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println("hello");
                    count.countDown();
                }
            });
            thread.start();
        }

        while(count.getCount()!=0){//堵塞等待5w个线程运行完毕

        }
        long end = System.currentTimeMillis();
        System.out.println("50000个线程都执行完了,共用时:"+(end-start)+"ms");


    }



    public static void main(){

        ThreadPool1 threadPool1 = new ThreadPool1();

        threadPool1.thread();

        threadPool1.threadPool();

    }

}
