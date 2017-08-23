package com.example.demo.onetest;

/**
 * Created by lenovo on 2017/8/22.
 */
/*
* 验证 try catch finally 下的return 使用
*
*
* */
public class ReturnTest {


    public static int func(int arg){

        int i   = 0;

        try {
            System.out.println("in try……");
            i = 1000 / arg ;
            //return i ;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("in catching ……");
            return 1000;
        }finally {
            System.out.println("in finally ……");
           // return  10000;
        }

        return i;

    }


    public static void main(String[] args){

        System.out.println(ReturnTest.func(0));


    }
}
