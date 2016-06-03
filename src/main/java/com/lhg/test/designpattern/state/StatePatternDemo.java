package com.lhg.test.designpattern.state;

/**
 * Created by liux on 16-3-18.
 */
public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        State startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState().toString());

        State stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());

    }
}
