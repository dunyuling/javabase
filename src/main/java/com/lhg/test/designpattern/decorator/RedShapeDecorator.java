package com.lhg.test.designpattern.decorator;

/**
 * Created by liuhg on 16-2-29.
 */
public class RedShapeDecorator extends ShapeDecorator {

    protected RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        setRedBorder(shape);
    }

    private void setRedBorder(Shape shape){
        System.out.println("Border Color: Red");
    }
}
