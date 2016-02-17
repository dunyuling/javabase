package com.lhg.test.designpattern.builder;

/**
 * Created by liuhg on 16-2-17.
 */
public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
