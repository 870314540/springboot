package com.sugar.test.design.observetest;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/1/23
 */
public class OctalObserver extends Observer {
    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}
