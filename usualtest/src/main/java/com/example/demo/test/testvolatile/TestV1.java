package com.example.demo.test.testvolatile;

/**
 * @author ThomasCui
 * @Descrption
 * @create 2018/8/8
 */
public class TestV1 {

    public volatile int   inc = 0;

    public void increase() {
        inc++;
    }

    public synchronized void syncIncrease() {
        inc++;
    }



    public void binaryToDecimal(int n){
        String str = "";
        while(n!=0){
            str = n%2+str;
            n = n/2;
        }
        System.out.println(str);
    }

    public static void main(String[] args) {

//        String result = Integer.toBinaryString(10);
        //int r = Integer.parseInt(result);
        //System.out.println(r);
//        System.out.println(result);
        TestV1 v1 = new TestV1();
        v1.binaryToDecimal(10);











    }
}
