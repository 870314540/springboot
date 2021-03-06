package com.example.demo.onetest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/7/28.
 */
//带有super超类型限定的通配符可以向泛型对易用写入
// 带有extends子类型限定的通配符可以向泛型对象读取。——《Core Java》
public class Food {
    static class Fruit extends Food{}
    static class Apple extends Fruit{}
    static class RedApple extends Apple{}

    public static void main(String[] args){
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // complie error:
        // flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());
        flist.add(null); // only work for null
/**
 * 对上面的说明：List<? extends Frut> 表示 “具有任何从Fruit继承类型的列表”，编译器无法确定List所持有的类型，所以无法安全的向其中添加对象。
 * 可以添加null,因为null 可以表示任何类型。所以List 的add 方法不能添加任何有意义的元素，但是可以接受现有的子类型List<Apple> 赋值。
 */
        Fruit fruit = flist.get(0);

        Apple apple = (Apple)flist.get(0);

        flist.contains(new Fruit());

        flist.contains(new Apple());

//**********************************************************

        List<? super Fruit> slist = new ArrayList<Fruit>();
        slist.add(new Fruit());

        slist.add(new Apple());

        slist.add(new RedApple());

// compile error:
      //  List<? super Fruit> tlist = new ArrayList<Apple>();

/**
 * List<? super Fruit> 表示“具有任何Fruit超类型的列表”，列表的类型至少是一个 Fruit 类型，因此可以安全的向其中添加Fruit 及其子类型。
 * 由于List<? super Fruit>中的类型可能是任何Fruit 的超类型，无法赋值为Fruit的子类型Apple的List<Apple>.
 */

     // compile error:

      //  Fruit item = slist.get(0);

       // 因为，List<? super Fruit>中的类型可能是任何Fruit 的超类型，所以编译器无法确定get返回的对象类型是Fruit,还是Fruit的父类Food 或 Object.


    }

}
