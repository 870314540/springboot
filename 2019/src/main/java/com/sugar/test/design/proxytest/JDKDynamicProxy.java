package com.sugar.test.design.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * java.lang.reflect.Proxy类的newProxyInstance()，是用于创建动态代理类和实例的静态方法.返回一个指定接口的代理类实例，该接口可以将方法调用指派到指定的调用处理程序。
 *
 * java.lang.reflect.InvocationHandler接口中的invoke()，在代理实例上处理方法调用并返回结果。当与方法关联的代理实例上调用方法时，将在调用处理程序上调用此方法。
 *
 *
 * @author cuiyt
 * @Descrption
 * @create 2019/1/22
 */
public class JDKDynamicProxy implements InvocationHandler {
    private Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * 获取被代理接口实例对象
     *
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 第一个参数的解释是：
     *
     * 1. 可以使用反射获取代理对象的信息（也就是proxy.getClass().getName()）。
     *
     * 2. 可以将代理对象返回以进行连续调用，这就是proxy存在的目的，因为this并不是代理对象。
     *
     *
     *
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println("Do something before");
           Object result = method.invoke(target, args);
           System.out.println("Do something after");
           return result;


    }

    public static void main(String[] args) {
        // jdk动态代理测试
        Subject subject = new JDKDynamicProxy(new RealSubject()).getProxy();
        subject.printName();

        subject.printClass();

        String t = null ;
        String[] t1 = t.split(",");

     }


}

