package com.lhg.test.designpattern.builder;

/**
 * Created by liuhg on 16-2-17.
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
