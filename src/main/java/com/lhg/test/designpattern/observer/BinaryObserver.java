package com.lhg.test.designpattern.observer;

/**
 * Created by liux on 16-3-18.
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("binary: " + Integer.toBinaryString(subject.getState()));
    }
}
