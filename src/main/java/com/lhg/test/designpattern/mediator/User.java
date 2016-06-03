package com.lhg.test.designpattern.mediator;

/**
 * Created by liux on 16-3-17.
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showMessage(String message) {
        ChatRoom.showMessage(this,message);
    }

}
