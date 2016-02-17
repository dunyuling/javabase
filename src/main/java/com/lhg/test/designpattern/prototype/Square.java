package com.lhg.test.designpattern.prototype;

/**
 * Created by liuhg on 16-2-17.
 */
public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}