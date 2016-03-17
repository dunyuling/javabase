package com.lhg.test.designpattern.observer;

/**
 * Created by liux on 16-3-18.
 */
public abstract class Observer {

    Subject subject;
    abstract void update();
}
