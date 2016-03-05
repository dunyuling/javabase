package com.lhg.test.designpattern.prototype;

/**
 * Created by liuhg on 16-2-17.
 */
public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape = ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType() + " \t "  + clonedShape.getId());
        clonedShape.draw();


        Shape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType() + " \t "  + clonedShape2.getId());
        clonedShape2.draw();

        Shape clonedShape3 = ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType() + " \t "  + clonedShape3.getId());
        clonedShape3.draw();
    }
}
