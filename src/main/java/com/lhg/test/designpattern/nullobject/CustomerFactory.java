package com.lhg.test.designpattern.nullobject;

/**
 * Created by liux on 16-3-19.
 */
public class CustomerFactory {

    static final String[] names = new String[]{"John","Jack","Mike","Harry"};

    public static AbstractCustomer getCustomer(String name) {
        for (String tempName : names) {
            if(name.equalsIgnoreCase(tempName)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
