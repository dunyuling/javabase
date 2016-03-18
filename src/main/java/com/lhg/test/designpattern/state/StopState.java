package com.lhg.test.designpattern.state;

/**
 * Created by liux on 16-3-18.
 */
public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("stop state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "stop state...";
    }
}
