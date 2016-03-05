package com.lhg.test.designpattern.facade;

/**
 * Created by liuhg on 16-2-29.
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker(new Circle(),new Rectangle(),new Square());
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
