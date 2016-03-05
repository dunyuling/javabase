package com.lhg.test.designpattern.bridge;

/**
 * Created by liuhg on 16-2-22.
 */
public class Circle extends Shape {

    private int x , y ,radius;

    protected Circle(int x, int y ,int radius, DrawApi drawApi) {
        super(drawApi);
//        this.drawApi = drawApi;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawApi.drawInterface(radius,x,y);
    }
}
