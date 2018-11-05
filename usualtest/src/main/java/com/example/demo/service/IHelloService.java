package com.example.demo.service;

/**
 * @author ThomasCui
 * @Descrption
 * @create 2018/5/30
 */
public interface IHelloService {

    boolean modifyValue(int value);

     void circlePrint() throws InterruptedException;
    int getValue();
}
