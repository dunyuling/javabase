package com.lhg.test.designpattern.nullobject;

/**
 * Created by liux on 16-3-19.
 */
public class NullCustomer extends AbstractCustomer {
    @Override
    boolean isNil() {
        return true;
    }

    @Override
    String getName() {
        return "Not Available in Customer Database";
    }
}
