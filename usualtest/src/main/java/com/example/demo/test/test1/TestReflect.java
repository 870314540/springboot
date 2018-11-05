package com.example.demo.test.test1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ThomasCui
 * @Descrption
 * @create 2018/7/17
 */
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

        Class<?> userClass = Class.forName("com.example.demo.test.test1.UserEntity");
        UserEntity userEntity = (UserEntity) userClass.newInstance();

        //第一种方法
        int money = userEntity.getMoney();

        //第二种方法,（无参的示例：借钱）
        Method getMoney = userClass.getMethod("getMoney");//得到方法对象
        Object money2 = getMoney.invoke(userEntity);//调用借钱方法，得到返回值
        System.out.println("实际拿到钱为：" + money2);

        //第二种方法,（单个参数的示例：还钱）
        Method repay1 = userClass.getMethod("repay",int.class);//得到方法对象,有参的方法需要指定参数类型
        repay1.invoke(userEntity,3000);//执行还钱方法，有参传参

        //第二种方法,（多个参数的示例：还钱）
        Method repay2 = userClass.getMethod("repay", String.class,int.class);//得到方法对象,有参的方法需要指定参数类型
        repay2.invoke(userEntity,"小飞",5000);//执行还钱方法，有参传参

        Field[] field=userClass.getDeclaredFields();

    }
}
