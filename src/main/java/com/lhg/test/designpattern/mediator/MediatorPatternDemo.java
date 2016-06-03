package com.lhg.test.designpattern.mediator;

/**
 * Created by liux on 16-3-17.
 */
public class MediatorPatternDemo {

    public static void main(String[] args) {
        User lily = new User("Lily");
        User john = new User("John");

        lily.showMessage("hi i'm lily");
        john.showMessage("hi i'm john");

    }


}
