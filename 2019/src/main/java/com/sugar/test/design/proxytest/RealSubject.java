package com.sugar.test.design.proxytest;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/1/22
 */
public class RealSubject extends AbstractName implements Subject {
    public void printName() {
        super.name = "112";
        System.out.println(super.name);

        System.out.println("RealSubject");
    }

    public void printClass() {
        System.out.println("RealSubject.class");
    }

    @Override
    String getName(){
        return "1234";
    }
}
