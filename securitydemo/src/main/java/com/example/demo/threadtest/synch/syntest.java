package com.example.demo.threadtest.synch;

/**
 * Created by lenovo on 2017/8/7.
 */
public class syntest extends Thread{
    SynTest1 sy ;

    public syntest(SynTest1 sy){
        this.sy = sy ;
    }

    @Override
    public void run(){
        try {
            sy.printNum();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] ars){
        SynTest1 sy  = new SynTest1();
        syntest ta = new syntest(sy);
        syntest tb = new syntest(sy);

        ta.start();
        tb.start();


    }
}
