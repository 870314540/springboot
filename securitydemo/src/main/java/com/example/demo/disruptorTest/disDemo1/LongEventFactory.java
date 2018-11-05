package com.example.demo.disruptorTest.disDemo1;

import com.lmax.disruptor.EventFactory;

/**
 * @author ThomasCui
 * @Descrption
 * @create 2018/10/16
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
