package com.lhg.test.designpattern.visitor;

/**
 * Created by liux on 16-3-19.
 */
public interface ComputerPartVisitor {

    void visit(Computer computer);
    void visit(Keyboard keyboard);
    void visit(Mouse mouse);
    void visit(Monitor monitor);
}
