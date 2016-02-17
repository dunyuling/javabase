package com.lhg.test.designpattern.builder;

/**
 * Created by liuhg on 16-2-17.
 */
public class Pepsi extends ColdDrink {

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
