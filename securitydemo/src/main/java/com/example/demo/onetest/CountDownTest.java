package com.example.demo.onetest;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lenovo on 2017/8/23.
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
    }

}
