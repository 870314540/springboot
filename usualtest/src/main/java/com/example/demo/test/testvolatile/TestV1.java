package com.example.demo.test.testvolatile;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/8/8
 */
public class TestV1 {

    public volatile int   inc = 0;

    public void increase() {
        inc++;
    }

    public synchronized void syncIncrease() {
        inc++;
    }

    public static void main(String[] args) {












    }
}
