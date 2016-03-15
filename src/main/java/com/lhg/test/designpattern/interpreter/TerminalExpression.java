package com.lhg.test.designpattern.interpreter;

/**
 * Created by liux on 16-3-15.
 */
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }


    @Override
    public boolean interpreter(String context) {
        return context.contains(data);
    }
}
