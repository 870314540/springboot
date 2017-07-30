package com.example.demo.threadtest.start;

/**
 * Created by sugar on 17-7-30.
 */
public class Thread2 implements Runnable{
    private String name;

    public Thread2(String name) {
        this.name=name;
    }
    @Override
    public void run() {
        for (int i = 0 ; i< 100 ;i++){
            System.out.println(i);
            try{
                Thread.sleep((int)Math.random()*10);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
