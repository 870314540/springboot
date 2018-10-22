package com.example.demo.onetest;

import sun.misc.Unsafe;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Unsafe test
 *
 * @author cuiyt
 * @Descrption
 * @create 2018/10/22
 */
public class UnsafeTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        // 通过反射得到theUnsafe对应的Field对象
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        // 设置该Field为可访问
        field.setAccessible(true);
        // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
        Unsafe unsafe = (Unsafe) field.get(null);
        System.out.println(unsafe);

        //通过allocateInstance直接创建对象
        User user = (User) unsafe.allocateInstance(User.class);
        Student student = (Student) unsafe.allocateInstance(Student.class);


        Class userClass = user.getClass();
        Field name = userClass.getDeclaredField("name");
        Field age = userClass.getDeclaredField("age");
        Field id = userClass.getDeclaredField("id");

        //获取实例变量name和age在对象内存中的偏移量并设置值
        unsafe.putInt(user, unsafe.objectFieldOffset(age), 18);
        unsafe.putObject(user, unsafe.objectFieldOffset(name), "android TV");

        // 这里返回 User.class，
        Object staticBase = unsafe.staticFieldBase(id);
        System.out.println("staticBase:" + staticBase);

        //获取静态变量id的偏移量staticOffset
        long staticOffset = unsafe.staticFieldOffset(userClass.getDeclaredField("id"));
        //获取静态变量的值
        System.out.println("设置前的ID:" + unsafe.getObject(staticBase, staticOffset));
        //设置值
        unsafe.putObject(staticBase, staticOffset, "SSSSSSSS");
        //获取静态变量的值
        System.out.println("设置前的ID:" + unsafe.getObject(staticBase, staticOffset));
        //输出USER
        System.out.println("输出USER:" + user.toString());

        long data = 1000;
        byte size = 1;//单位字节

        //调用allocateMemory分配内存,并获取内存地址memoryAddress
        long memoryAddress = unsafe.allocateMemory(size);
        //直接往内存写入数据
        unsafe.putAddress(memoryAddress, data);
        //获取指定内存地址的数据
        long addrData = unsafe.getAddress(memoryAddress);
        System.out.println("addrData:" + addrData);

        System.out.println("===========================");


        Field field1 = User.class.getDeclaredField("theUser");
        // 设置该Field为可访问
        field1.setAccessible(true);

        System.out.println(field1.getName());
        System.out.println((User) field1.get(null));

        System.out.println(1147018/100);

//        System.out.println("===========================四种队列=====================");
//        Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool(1);
//        Executors.newSingleThreadExecutor();
//        Executors.newScheduledThreadPool(1);
//        System.out.println("===========================四种队列=====================");


        System.out.println("===========================");

        /**
         * 输出结果:
         sun.misc.Unsafe@6f94fa3e
         staticBase:class geym.conc.ch4.atomic.User
         设置前的ID:USER_ID
         设置前的ID:SSSSSSSS
         输出USER:User{name='android TV', age=18', id=SSSSSSSS'}
         addrData:1000
         */

    }
}
class Student {
    public Student() {
        System.out.println("user 构造方法被调用");
    }

    private String name;
    private int age;
    private static String id = "USER_ID";
    private final static Student theUser = new Student();

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age + '\'' +
                ", id=" + id + '\'' +
                '}';
    }
}

class User {
    public User() {
        System.out.println("user 构造方法被调用");
    }

    private String name;
    private int age;
    private static String id = "USER_ID";
    private final static User theUser = new User();

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age + '\'' +
                ", id=" + id + '\'' +
                '}';
    }


}
