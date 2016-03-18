package com.lhg.test.designpattern.state;

/**
 * Created by liux on 16-3-18.
 */
public class Context {

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
