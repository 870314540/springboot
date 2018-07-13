package com.example.demo.onetest;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2017/8/23.
 * CountDownLatch ：用来同步一个或者多个执行多个任务的线程。它只能使用一次。
 * CountDownLatch类有3个基本元素：

    初始值决定CountDownLatch类需要等待的事件的数量。
    await() 方法, 被等待全部事件终结的线程调用。 （await(long time, TimeUnit unit): ）
    countDown() 方法，事件在结束执行后调用。
 * countDownLatch.countDown(); 建议放在 finally里执行
 */

public class CountDownTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

      new Thread(new Runnable() {
          @Override
          public void run() {
              System.out.println(1);
              countDownLatch.countDown();
          }
      }).start();

         new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(3);

                countDownLatch.countDown();

            }
        }).start();

        countDownLatch.await();
        System.out.println(123);  //123 肯定在 1 和3 之后

//        int curMonth=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
//
//        System.out.println(curMonth);

        String str1= "12,123,4,5,8,99,6,888,";
        String[] strs = str1.split(",");
        List<String> list = Arrays.asList(strs);

        System.out.println(list.contains("12"));


    }


}
