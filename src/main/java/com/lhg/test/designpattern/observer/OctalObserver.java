package com.lhg.test.designpattern.observer;

/**
 * Created by liux on 16-3-18.
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("ocatl: " + Integer.toOctalString(subject.getState()));
    }
}
