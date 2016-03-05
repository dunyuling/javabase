package com.lhg.test.designpattern.decorator;

/**
 * Created by liuhg on 16-2-29.
 */
public abstract class ShapeDecorator implements Shape{

    protected Shape shape;

    protected ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    public void draw() {
        shape.draw();
    }
}
