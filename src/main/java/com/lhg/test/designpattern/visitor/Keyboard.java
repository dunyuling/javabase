package com.lhg.test.designpattern.visitor;

/**
 * Created by liux on 16-3-19.
 */
public class Keyboard implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
