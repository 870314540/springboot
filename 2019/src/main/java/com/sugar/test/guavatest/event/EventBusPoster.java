package com.sugar.test.guavatest.event;

import com.google.common.eventbus.EventBus;

/**
 * EventBus事件总线
 * @author cuiyt
 * @Descrption
 * @create 2019/1/23
 */
public class EventBusPoster {
    private EventBus eventBus = new EventBus();

    public void post(String message) {
        eventBus.post(message);
    }

    public void addListener(EventBusListener eventBusListener) {
        eventBus.register(eventBusListener);
    }




}
