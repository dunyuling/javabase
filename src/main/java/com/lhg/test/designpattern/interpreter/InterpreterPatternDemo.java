package com.lhg.test.designpattern.interpreter;

/**
 * Created by liux on 16-3-15.
 */
public class InterpreterPatternDemo {

    private static Expression getMaleExpression() {
        Expression expression1 = new TerminalExpression("Will");
        Expression expression2 = new TerminalExpression("John");
        return new OrExpression(expression1,expression2);
    }

    private static Expression getMarriedWomenExpression() {
        Expression expression1 = new TerminalExpression("Lisa");
        Expression expression2 = new TerminalExpression("Woman");
        return new AndExpression(expression1,expression2);
    }

    public static void main(String[] args) {
        boolean isMale = getMaleExpression().interpreter("John");
        boolean isMarriedWoman = getMarriedWomenExpression().interpreter("Lisa Woman");
        System.out.println("isMale: " + isMale);
        System.out.println("isMarriedWoman: " + isMarriedWoman);

    }
}
