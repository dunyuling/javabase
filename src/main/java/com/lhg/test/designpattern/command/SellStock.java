package com.lhg.test.designpattern.command;

/**
 * Created by liuhg on 16-3-14.
 */
public class SellStock implements Order {

    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
