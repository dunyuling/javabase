package com.lhg.test.designpattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhg on 16-3-14.
 */
public class Broker {

    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrder() {
        orderList.forEach(Order::execute);
        orderList.clear();
    }
}
