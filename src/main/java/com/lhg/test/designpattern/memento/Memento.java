package com.lhg.test.designpattern.memento;

/**
 * Created by liux on 16-3-17.
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
