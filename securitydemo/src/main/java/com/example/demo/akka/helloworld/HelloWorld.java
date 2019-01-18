package com.example.demo.akka.helloworld;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/1/18
 */
public class HelloWorld extends UntypedActor {

    @Override
    public void preStart() {
        // create the greeter actor
        final ActorRef greeter =
                getContext().actorOf(Props.create(Greeter.class), "greeter");
        // tell it to perform the greeting
        greeter.tell(Greeter.Msg.GREET, getSelf());
    }

    @Override
    public void onReceive(Object msg) throws Exception {
        if (msg == Greeter.Msg.DONE) {
            // when the greeter is done, stop this actor and with it the application
            System.out.println("----hello world onReceive ----");
            getContext().stop(getSelf());
        } else unhandled(msg);
    }

    public static void main(String[] args) {
        //创建ActorSystem
        ActorSystem system = ActorSystem.create("HelloWorld");
        //创建ActorRef
        final ActorRef actorRef = system.actorOf(Props.create(HelloWorld.class), "HelloWorld");
        for (int i = 0; i < 10000; i++) {
            actorRef.tell(Greeter.Msg.GREET, actorRef);
        }

    }


}