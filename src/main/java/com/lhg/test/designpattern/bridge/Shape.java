package com.lhg.test.designpattern.bridge;

/**
 * Created by liuhg on 16-2-22.
 */
public abstract class Shape {

    protected DrawApi drawApi;

    protected Shape(DrawApi drawApi) {
        this.drawApi = drawApi;
    }

    public abstract void draw();
}
