package com.example.demo.disruptor;


import com.lmax.disruptor.EventHandler;

/**
 * @author ThomasCui
 * @Descrption
 * @create 2018/10/29
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("event :"+event.getValue()+",sequence:"+sequence+"endOfBatch:"+endOfBatch);
    }
}
