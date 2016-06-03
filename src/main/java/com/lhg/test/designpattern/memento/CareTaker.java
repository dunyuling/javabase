package com.lhg.test.designpattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liux on 16-3-17.
 */
public class CareTaker {

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
