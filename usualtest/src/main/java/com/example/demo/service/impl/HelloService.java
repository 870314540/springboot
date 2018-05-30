package com.example.demo.service.impl;

import com.example.demo.service.IHelloService;
import org.springframework.stereotype.Service;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/5/30
 */
@Service
public class HelloService implements IHelloService {

    public  static volatile int flag = 0 ;
    @Override
    public boolean modifyValue(int value) {
        flag = value ;
        return true;
    }
    @Override
    public int getValue() {
        return flag;
    }


    @Override
    public void circlePrint() throws InterruptedException {
        while (flag == 0){
            for(int i = 0 ; i <10 ; i++){
                Thread.sleep(100);
                System.out.println(i);
            }
        }
    }
}
