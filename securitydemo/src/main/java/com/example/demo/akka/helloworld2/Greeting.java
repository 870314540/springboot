package com.example.demo.akka.helloworld2;

import java.io.Serializable;

/**
 *
 * @author cuiyt
 * @Descrption
 * @create 2019/1/18
 */
public class Greeting implements Serializable {
    public final String message;
    public Greeting(String message) {
        this.message = message;
    }
}
