package com.example.demo.onetest;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by lenovo on 2017/8/23.
 *
 * CyclicBarrier初始化时规定一个数目，然后计算调用了CyclicBarrier.await()进入等待的线程数。当线程数达到了这个数目时，所有进入等待状态的线程被唤醒并继续。
 CyclicBarrier就象它名字的意思一样，可看成是个障碍， 所有的线程必须到齐后才能一起通过这个障碍。
 CyclicBarrier初始时还可带一个Runnable的参数， 此Runnable任务在CyclicBarrier的数目达到后，所有其它线程被唤醒前被执行。

 CyclicBarrier还提供一个更高级的构造函数CyclicBarrier(int parties, Runnable barrierAction)，用于在线程到达屏障时，优先执行barrierAction，方便处理更复杂的业务场景。

 */
public class CyclicBarrierTest {
    private static final int THREAD_NUM = 10;
    public static void main(String[] args){
        CyclicBarrier cb = new CyclicBarrier(10, new Runnable() {
            //当所有线程到达barrier时执行
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("Inside Barrier");
            }
        });

        for(int i=0;i<THREAD_NUM;i++){
            new Thread(new WorkProcesser(cb)).start();
        }

    }

    public static class WorkProcesser  implements Runnable{
        CyclicBarrier barrier ;

        public WorkProcesser( CyclicBarrier cb){
            this.barrier = cb ;
        }
        @Override
        public void run() {
            // TODO Auto-generated method stub
            try{
                System.out.println("Worker's waiting");
                //线程在这里等待，直到所有线程都到达barrier。
                barrier.await();
                System.out.println("ID:"+Thread.currentThread().getId()+" Working");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
