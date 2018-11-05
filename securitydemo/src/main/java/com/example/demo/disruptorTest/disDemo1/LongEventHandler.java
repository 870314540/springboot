package com.example.demo.disruptorTest.disDemo1;

import com.lmax.disruptor.EventHandler;

/**
 * @author ThomasCui
 * @Descrption
 * @create 2018/10/16
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("Event: " + longEvent);
    }
}
