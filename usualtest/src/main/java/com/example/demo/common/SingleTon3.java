package com.example.demo.common;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/12/7
 */
public class SingleTon3 {
    private SingleTon3(){};             //私有化构造方法

    private static volatile SingleTon3 singleTon=null;

    public static SingleTon3 getInstance(){

        //第一次校验
        if(singleTon==null){

            synchronized(SingleTon3.class){

                //第二次校验

                if(singleTon==null){
                    singleTon=new SingleTon3();
                }
            }
        }
        return singleTon;
    }

    public static void main(String[]args){
        for(int i=0;i<200;i++){
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName()+":"+SingleTon3.getInstance().hashCode());
                }
            }).start();
        }

    }
}
