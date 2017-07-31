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
        //stop 已被弃用:它在终止一个线程时会强制中断线程的执行，不管run方法是否执行完了，并且还会释放这个线程所持有的所有的锁对象。这一现象会被其它因为请求锁而阻塞的线程看到，使他们继续向下执行。

       // suspend被弃用的原因是因为它会造成死锁。suspend方法和stop方法不一样，它不会破坏对象和强制释放锁，相反它会一直保持对锁的占有，一直到其他的线程调用resume方法，它才能继续向下执行。





    }
}
