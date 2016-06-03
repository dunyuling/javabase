package com.lhg.test.designpattern.nullobject;

/**
 * Created by liux on 16-3-19.
 */
public class RealCustomer extends AbstractCustomer {

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    boolean isNil() {
        return false;
    }

    @Override
    String getName() {
        return name;
    }
}
