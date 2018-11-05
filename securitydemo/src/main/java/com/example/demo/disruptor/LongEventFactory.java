package com.example.demo.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author ThomasCui
 * @Descrption
 * @create 2018/10/29
 */
public class LongEventFactory implements EventFactory {
    @Override
    public Object newInstance() {
        return new LongEvent();
    }
}
