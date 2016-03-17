package com.lhg.test.designpattern.mediator;

/**
 * Created by liux on 16-3-17.
 */
public class ChatRoom {

    public static void showMessage(User user ,String message) {
        System.out.println("name: " + user.getName() + ", \t message: " + message);
    }
}
