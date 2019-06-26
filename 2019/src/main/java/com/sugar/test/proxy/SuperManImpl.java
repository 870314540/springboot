package com.sugar.test.proxy;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/6/26
 */
public class SuperManImpl implements IMan {
    public String eat() {
        return "I hate eat!";
    }

    public String run() {
        return "I like run!";
    }

    @Override
    public void printName(String name) {
        System.out.println("superMan:" + name);
    }
}
