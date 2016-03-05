package com.lhg.test.designpattern.flyweight;

/**
 * Created by liuhg on 16-2-29.
 */
public class FlyWeightPatternDemo {

    public static void main(String[] args) {
        FlyWeightPatternDemo flyWeightPatternDemo = new FlyWeightPatternDemo();
        ShapeFactory shapeFactory = new ShapeFactory();
        for (int i = 0; i < 20; i++) {
            shapeFactory.getCircle(flyWeightPatternDemo.getRandomX(),flyWeightPatternDemo.getRandomY(),5,flyWeightPatternDemo.getRandomColor());
        }
    }

    String[] colors = new String[]{"red", "green", "blue", "black", "white" };

    private String getRandomColor() {
        int index = (int) (Math.random() * 5);
        return colors[index];
    }

    private int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private int getRandomY() {
        return (int) (Math.random() * 100);
    }
}
