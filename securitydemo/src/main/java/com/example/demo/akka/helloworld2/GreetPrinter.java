package com.example.demo.akka.helloworld2;

import akka.actor.UntypedActor;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/1/18
 */
public class  GreetPrinter extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Greeting)
            System.out.println(((Greeting) message).message);
    }
}
