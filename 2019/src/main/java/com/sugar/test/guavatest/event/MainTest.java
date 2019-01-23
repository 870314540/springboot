package com.sugar.test.guavatest.event;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/1/23
 */
public class MainTest {
    public static void main(String[] args) {
        EventBusPoster eventBusPoster = new EventBusPoster();
        EventBusListener eventBusListener = new EventBusListener();
        eventBusPoster.addListener(eventBusListener);
        eventBusPoster.post("hello world!");
        eventBusPoster.post("你好，世界！");
    }
}
