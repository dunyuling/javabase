package com.lhg.test.designpattern.builder;

/**
 * Created by liuhg on 16-2-17.
 */
public class ChickenBurger extends Burger {

    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
