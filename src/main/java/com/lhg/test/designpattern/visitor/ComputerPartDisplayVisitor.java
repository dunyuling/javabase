package com.lhg.test.designpattern.visitor;

/**
 * Created by liux on 16-3-19.
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    @Override
    public void visit(Computer computer) {
        System.out.println("computer");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("keyboard");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("mouse");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("monitor");
    }
}
