package com.sugar.test.dubbo;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/3/14
 */
public class SpiTest {


    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();

      //创建Programmer类

        CtClass cc = pool.makeClass("com.mining.producer");

        //定义code方法 

        CtMethod method = CtNewMethod.make("public void code(){}", cc);

        //插入方法代码 

        method.insertBefore("System.out.println(\"I'm aProgrammer,Just Coding.....\");");
        cc.addMethod(method);
       //保存生成的字节码 

        cc.writeFile("~/Document");

    }

}
