package com.lhg.test.designpattern.strategy;

/**
 * Created by liux on 16-3-19.
 */
public class OperationMultiply implements Strategy {

    @Override
    public int doOperation(int a, int b) {
        return a * b;
    }
}
