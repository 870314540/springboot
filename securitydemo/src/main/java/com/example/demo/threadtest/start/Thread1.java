package com.example.demo.threadtest.start;

/**
 * Created by sugar on 17-7-30.
 */
public class Thread1  extends Thread{
    private String name ;
    public Thread1(String name ){
        this.name = name ;
    }
    public void run(){
        for (int i = 0 ; i< 100 ;i++){
            System.out.println(i);
            try{
                this.sleep((int)Math.random()*10);
             }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
