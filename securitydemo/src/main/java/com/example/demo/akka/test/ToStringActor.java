package com.example.demo.akka.test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * 测试字符输出
 * @author cuiyt
 * @Descrption
 * @create 2019/1/18
 */
public class ToStringActor extends UntypedActor {
    @Override
    public void onReceive(Object message) {
        System.out.println(message.toString());
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //创建ActorSystem
        ActorSystem system = ActorSystem.create("toStringActor");
        //创建ActorRef
        final ActorRef toString = system.actorOf(Props.create(ToStringActor.class),"toString");
        for(int i=0;i<10000000;i++) {
            //sendMessage to actor
            toString.tell("test"+i,toString);
        }
        System.out.println("[结束]=======================");
    }


}
