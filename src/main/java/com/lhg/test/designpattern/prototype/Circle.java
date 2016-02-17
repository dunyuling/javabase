package com.lhg.test.designpattern.prototype;

/**
 * Created by liuhg on 16-2-17.
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}