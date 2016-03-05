package com.lhg.test.designpattern.flyweight;

import java.util.HashMap;

/**
 * Created by liuhg on 16-2-29.
 */
public class ShapeFactory {

    private HashMap<String,Circle> circleHashMap = new HashMap<>();

    public Circle getCircle(int x ,int y, int radius, String color) {
        Circle circle = circleHashMap.get(color);
        if (circle == null) {
            circle = new Circle(x,y,radius,color);
            circleHashMap.put(color,circle);
            //亮点
            System.out.println("Creating circle of color : " + color);
        }
        circle.draw();
        return circle;
    }
}
