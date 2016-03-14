package com.lhg.test.designpattern.command;

/**
 * Created by liuhg on 16-3-14.
 */
public class BuyStock implements Order {

    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
