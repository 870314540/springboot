package com.example.demo.test.test5;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/3/25
 */
public class Father {
     private String name ;
     private String age;

    public Father(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void getName(){
        System.out.println(this.name);
    }


    /**
     * 初始化过程是这样的： 
     *
     * 1.首先，初始化父类中的静态成员变量和静态代码块，按照在程序中出现的顺序初始化； 
     *
     * 2.然后，初始化子类中的静态成员变量和静态代码块，按照在程序中出现的顺序初始化； 
     *
     * 3.其次，初始化父类的普通成员变量和代码块，在执行父类的构造方法；
     *
     * 4.最后，初始化子类的普通成员变量和代码块，在执行子类的构造方法；
     *
     *
     * 5 . 父类引用强转成为子类引用 Father father = new Son(); Son son1 = (Son) father;
     */
}

