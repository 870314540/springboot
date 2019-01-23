package com.sugar.test.design.observetest;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/1/23
 */
public abstract  class Observer {
    //目标类
    protected Subject subject;
    public abstract void update();
}
