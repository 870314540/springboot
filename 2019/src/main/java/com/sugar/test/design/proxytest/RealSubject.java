package com.sugar.test.design.proxytest;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/1/22
 */
public class RealSubject implements Subject {
    public void printName() {
        System.out.println("RealSubject");
    }

    public void printClass() {
        System.out.println("RealSubject.class");
    }
}
