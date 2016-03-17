package com.lhg.test.designpattern.observer;

/**
 * Created by liux on 16-3-18.
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexObserver(subject);
        subject.setState(10);

        subject.setState(20);


    }
}
