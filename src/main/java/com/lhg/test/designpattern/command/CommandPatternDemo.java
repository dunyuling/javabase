package com.lhg.test.designpattern.command;

/**
 * Created by liuhg on 16-3-14.
 */
public class CommandPatternDemo {
    public static void main(String[] args) {
        Broker broker = new Broker();

        Stock stock = new Stock();

        Order buyStock = new BuyStock(stock);
        Order sellStock = new SellStock(stock);
        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);

        broker.placeOrder();

    }
}
