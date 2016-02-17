package com.lhg.test.designpattern.prototype;

/**
 * Created by liuhg on 16-2-17.
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}