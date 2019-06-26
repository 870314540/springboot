package com.sugar.test.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLOutput;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/6/26
 */
public class ProxyTest {

    public static void main(String[] args) throws NoSuchMethodException {

//        IMan man = (IMan) new ManProxy().bind(new ManImpl());
//        System.out.println(man.eat());
//
//        man = (IMan) new ManProxy().bind(new SuperManImpl());
//        System.out.println(man.eat());
//

        SuperManImpl superMan = new SuperManImpl();

        IMan proxy = (IMan) Proxy.newProxyInstance(superMan.getClass().getClassLoader(),superMan.getClass().getInterfaces(),new Man2Proxy(superMan));
        System.out.println(proxy.run());

        proxy.printName("123");
    }
}
