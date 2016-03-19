package com.lhg.test.designpattern.visitor;

/**
 * Created by liux on 16-3-19.
 */
public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}
