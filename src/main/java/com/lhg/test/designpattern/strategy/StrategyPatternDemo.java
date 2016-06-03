package com.lhg.test.designpattern.strategy;

/**
 * Created by liux on 16-3-19.
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Strategy add = new OperationAdd();
        Strategy subtract = new OperationSubtract();
        Strategy multiply = new OperationMultiply();

        Context context = new Context();
//        System.out.println(context.hashCode());
        context.setStrategy(add);
        System.out.println("3 + 2 = " + context.executeStrategy(3, 2));
        context.setStrategy(subtract);
        System.out.println("3 - 2 = " +context.executeStrategy(3, 2));
        context.setStrategy(multiply);
        System.out.println("3 * 2 = " +context.executeStrategy(3, 2));

        context = new Context();
//        System.out.println(context.hashCode());

    }
}
