package com.lhg.test.designpattern.bridge;

/**
 * Created by liuhg on 16-2-22.
 */
public class RedCircle implements DrawApi {
    @Override
    public void drawInterface(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x +
                ", y: " + y + "]");
    }
}
