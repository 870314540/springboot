package com.example.demo.threadtest.synch;

/**
 * Created by lenovo on 2017/8/7.
 */
public class SynTest1 {

    public    void printNum() throws InterruptedException {
        System.out.println(Thread.currentThread());
        for(int i = 0 ;i < 10 ;i++){
            System.out.print(i+" ");
            Thread.sleep(100);
        }
    }
    /**
     *结果不定
     * Thread[Thread-0,5,main]
     Thread[Thread-1,5,main]
     0 0 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9
     */
//    public synchronized  void printNum() throws InterruptedException {
//        System.out.println(Thread.currentThread());
//        for(int i = 0 ;i < 10 ;i++){
//            System.out.print(i+" ");
//            Thread.sleep(100);
//        }
//    }
    /*
    *
    * 结果：Thread[Thread-0,5,main]
0 1 2 3 4 5 6 7 8 9 Thread[Thread-1,5,main]
0 1 2 3 4 5 6 7 8 9
     */
}
