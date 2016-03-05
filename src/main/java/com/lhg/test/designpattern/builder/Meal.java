package com.lhg.test.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhg on 16-2-17.
 */
public class Meal {

    private List<Item> itemList = new ArrayList<>();

    public void addItem(Item item) {
        itemList.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (Item item : itemList) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        itemList.forEach(item -> {
            System.out.println("Item: " + item.name() + " ,Packing: " + item.packing().pack() + " ,Price: " + item.price());
        });
    }
}
