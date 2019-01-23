package com.sugar.test.guavatest.event;

import com.google.common.eventbus.Subscribe;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/1/23
 */
public class EventBusListener {
    @Subscribe
    public void listener(String message) {
        System.out.println("receive eventbus message:" + message);
    }
}
