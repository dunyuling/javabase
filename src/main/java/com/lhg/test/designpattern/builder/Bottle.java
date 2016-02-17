package com.lhg.test.designpattern.builder;

/**
 * Created by liuhg on 16-2-17.
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
