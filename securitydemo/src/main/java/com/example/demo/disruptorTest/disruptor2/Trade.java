package com.example.demo.disruptorTest.disruptor2;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Thomas
 * @Descrption
 * @create 2018/11/5
 */
@Getter
@Setter
public class Trade {
    private String id;//ID
    private String name;
    private double price;//金额
    private AtomicInteger count = new AtomicInteger(0);
}
