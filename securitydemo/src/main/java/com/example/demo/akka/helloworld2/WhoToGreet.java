package com.example.demo.akka.helloworld2;

import java.io.Serializable;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/1/18
 */
public class WhoToGreet implements Serializable {
    public final String who;
    public WhoToGreet(String who) {
        this.who = who;
    }
}