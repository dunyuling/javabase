package com.lhg.test.designpattern.visitor;

/**
 * Created by liux on 16-3-19.
 */
public class VisitorPatternDemo {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
