package com.lhg.test.designpattern.memento;

/**
 * Created by liux on 16-3-17.
 */
public class MementoPatternDemo {
    public static void main(String[] args) {

        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("state1");
        Memento memento1 = originator.saveStateToMemento();
        careTaker.add(memento1);

        originator.setState("state2");
        Memento memento2 = originator.saveStateToMemento();
        careTaker.add(memento2);

        System.out.println(originator.getState());
        System.out.println(careTaker.get(0).getState());


          //original demo
//        Originator originator = new Originator();
//        CareTaker careTaker = new CareTaker();

//        originator.setState("State #1");
//        originator.setState("State #2");
//        careTaker.add(originator.saveStateToMemento());
//
//        originator.setState("State #3");
//        careTaker.add(originator.saveStateToMemento());
//
//        originator.setState("State #4");
//        System.out.println("Current State: " + originator.getState());
//
//        originator.getStateFromMemento(careTaker.get(0));
//        System.out.println("First saved State: " + originator.getState());
//        originator.getStateFromMemento(careTaker.get(1));
//        System.out.println("Second saved State: " + originator.getState());
//

    }
}
