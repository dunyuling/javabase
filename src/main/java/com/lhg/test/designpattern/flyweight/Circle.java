package com.lhg.test.designpattern.flyweight;

/**
 * Created by liuhg on 16-2-29.
 */
public class Circle implements Shape {

    private int x, y, radius;

    private String color;

    public Circle(int x,int y ,int radius,String color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("draw x: " + x + " ,y: " + y + " ,radius: " + radius + " ,color: " + color + " ,hashCode: " + hashCode());
    }
}
//1836019240 4
//325040804 6
//1173230247 2
//856419764 4
//621009875 4