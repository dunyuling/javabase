package com.lhg.test.designpattern.decorator;

/**
 * Created by liuhg on 16-2-29.
 */
public class DecoratorPatternDemo {

    public static void main(String[] args) {
//        Shape circle = new Circle();
//        Shape rectangle = new Rectangle();
//
//        Shape circleDecorator = new RedShapeDecorator(circle);
//        circleDecorator.draw();
//
//        Shape rectangleDecorator = new RedShapeDecorator(rectangle);
//        rectangleDecorator.draw();

        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
