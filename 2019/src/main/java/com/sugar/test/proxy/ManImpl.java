package com.sugar.test.proxy;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/6/26
 */
public class ManImpl implements IMan {
    public String eat() {
        return "I like eat!";
    }

    public String run() {
        return "I hate run!";
    }

    @Override
    public void printName(String name) {
        System.out.println("Man:" + name);
    }
}
