package com.lhg.test.designpattern.builder;

/**
 * Created by liuhg on 16-2-17.
 */
public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }
}
