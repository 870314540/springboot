package com.example.demo.threadtest.stop;

/**
 * Created by sugar on 17-7-30.
 */
public class Thread1 extends Thread{

    private String name ;
    public Thread1(String name ){
        this.name = name ;
    }
    public void run(){
        for (int i = 0 ; i< 10000 ;i++){
            System.out.println(i);
        }

    }




}
