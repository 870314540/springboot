package com.sugar.test.design.observetest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/1/23
 */
public class Subject {
    private List<Observer> observers
            = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        //通知观察者
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
