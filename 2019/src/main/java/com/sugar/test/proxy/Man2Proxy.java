package com.sugar.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/6/26
 */
public class Man2Proxy implements InvocationHandler {


    private Object object;

    Man2Proxy(Object o){
        object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("run")) {
            System.out.println("runtest!");
            return method.invoke(object, args);
        } else if (method.getName().equals("eat")) {
            System.out.println("eat!");
            return method.invoke(object, args);
        }else if (method.getName().equals("printName")) {
            System.out.println("printName!");
            return method.invoke(object, args);
        }

        return null;
    }
}
