package com.lhg.test.designpattern.decorator;

/**
 * Created by liuhg on 16-2-29.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
