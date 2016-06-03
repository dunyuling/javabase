package com.lhg.test.designpattern.state;

/**
 * Created by liux on 16-3-18.
 */
public class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "start state...";
    }
}
