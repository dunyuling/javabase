package com.lhg.test.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by liuhuiguang on 15-11-25.
 */
public class CollectionGenFooDemo {
    public static void main(String args[]) {
        CollectionGenFoo<ArrayList> listFoo = null;
        listFoo = new CollectionGenFoo<ArrayList>(new ArrayList());
        // 出错了,不让这么干。
        // 原来作者写的这个地方有误，需要将listFoo改为listFoo1
        // 需要将CollectionGenFoo<Collection>改为CollectionGenFoo<ArrayList>
//         CollectionGenFoo<Collection> listFoo1 = null;
//        listFoo1 = new CollectionGenFoo<Collection>(new ArrayList());
//        System.out.println("实例化成功!");

        CollectionGenFooDemo ea = new CollectionGenFooDemo();
        ea.f(" ");
        ea.f(10);
        ea.f('a');
        ea.f(ea);
    }

    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }
}




