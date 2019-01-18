package com.example.demo.akka.helloworld;

import akka.actor.UntypedActor;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/1/18
 */
//UntypedActor仅仅定义一个抽象方法,就是上面提到onReceive(Object message)方法,该方法实现了角色行为
public class  Greeter extends UntypedActor {

    public static enum Msg {
        GREET, DONE;
    }

    @Override
    public void onReceive(Object msg) {
        if (msg == Msg.GREET) {
            System.out.println("Hello World!");
            getSender().tell(Msg.DONE, getSelf());
        } else unhandled(msg);
    }

}