package com.lhg.test.generic;

import java.util.Collection;

/**
 * Created by liuhuiguang on 15-11-25.
 */
public class CollectionGenFoo<T extends Collection> {

    private T x;

    public CollectionGenFoo(T x) {
        this.x = x;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }
}
