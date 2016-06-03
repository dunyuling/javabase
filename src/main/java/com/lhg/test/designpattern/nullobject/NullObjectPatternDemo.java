package com.lhg.test.designpattern.nullobject;

/**
 * Created by liux on 16-3-19.
 */
public class NullObjectPatternDemo {
    public static void main(String[] args) {
        AbstractCustomer customer1 = CustomerFactory.getCustomer("John");
        AbstractCustomer customer2 = CustomerFactory.getCustomer("Jack");
        AbstractCustomer customer3 = CustomerFactory.getCustomer("Mike");
        AbstractCustomer customer4 = CustomerFactory.getCustomer("Harry");
        AbstractCustomer customer5 = CustomerFactory.getCustomer("liux");

        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
        System.out.println(customer5.getName());
    }
}
