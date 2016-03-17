package com.lhg.test.designpattern.observer;

/**
 * Created by liux on 16-3-18.
 */
public class HexObserver extends Observer {


    public HexObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("hex: " + Integer.toHexString(subject.getState()));
    }
}
