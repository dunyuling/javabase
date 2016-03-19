package com.lhg.test.designpattern.strategy;

/**
 * Created by liux on 16-3-19.
 */
public class Context {

    private Strategy strategy;

    public Context() {

    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        int result = 0;
        if (strategy instanceof OperationAdd) {
            result = strategy.doOperation(a, b);
        } else if (strategy instanceof OperationSubtract) {
            result = strategy.doOperation(a, b);
        } else if (strategy instanceof OperationMultiply) {
            result = strategy.doOperation(a, b);
        }
        return result;

    }
}
