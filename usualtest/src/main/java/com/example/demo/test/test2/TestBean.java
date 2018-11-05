package com.example.demo.test.test2;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;

/**
 * @author ThomasCui
 * @Descrption
 * @create 2018/7/27
 */
public class TestBean {


    public static void main(String[] args) {


        //test1
        Bean1 bean1 = new Bean1();
        Bean2 bean2 = new Bean2();
        bean1.setV1("123");
        bean1.setV2("321");
        bean1.setV3("333");
        BeanUtils.copyProperties(bean1, bean2);
        System.out.println(JSON.toJSONString(bean2));


        //test2
        Bean1 beana = new Bean1();
        Bean2 beanb = new Bean2();
        beanb.setV1("aaa");
        beanb.setV2("bbb");
        BeanUtils.copyProperties(beanb, beana);
        System.out.println(JSON.toJSONString(beana));

        //test3
        Bean1 bean11 = new Bean1();
        Bean3 bean3 = new Bean3();
        bean11.setV1("123");
        bean11.setV2("321");
        bean11.setV3("333");
        BeanUtils.copyProperties(bean11, bean3);
        System.out.println(JSON.toJSONString(bean3));




    }
}
