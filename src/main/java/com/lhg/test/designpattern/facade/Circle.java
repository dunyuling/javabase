package com.lhg.test.designpattern.facade;

/**
 * Created by liuhg on 16-2-29.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
