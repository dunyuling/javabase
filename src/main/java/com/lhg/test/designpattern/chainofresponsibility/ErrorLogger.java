package com.lhg.test.designpattern.chainofresponsibility;

/**
 * Created by liuhg on 16-3-14.
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
//        System.out.println("Error Console::Logger: " + message);

        System.out.println("[" +getLevel(level) + "]: " + message);
    }
}
