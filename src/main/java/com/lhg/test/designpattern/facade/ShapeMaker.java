package com.lhg.test.designpattern.facade;

/**
 * Created by liuhg on 16-2-29.
 */
public class ShapeMaker {
    Circle circle ;
    Rectangle rectangle;
    Square square;

    public ShapeMaker(Circle circle, Rectangle rectangle, Square square) {
        this.circle = circle;
        this.rectangle = rectangle;
        this.square = square;
    }

    void drawCircle() {
        circle.draw();
    }

    void drawRectangle() {
        rectangle.draw();
    }

    void drawSquare() {
        square.draw();
    }
}
