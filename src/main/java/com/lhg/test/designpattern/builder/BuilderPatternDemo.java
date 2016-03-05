package com.lhg.test.designpattern.builder;

/**
 * Created by liuhg on 16-2-17.
 */
public class BuilderPatternDemo {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("Non-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());

        System.out.println();
        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("\n\nVeg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());
    }
}
