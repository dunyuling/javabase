package com.lhg.test.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liux on 16-3-18.
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);

    }

    public void notifyAllObservers() {
        observers.forEach(Observer::update);
        System.out.println("-----");
    }
}
