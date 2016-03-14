package com.lhg.test.designpattern.chainofresponsibility;

/**
 * Created by liuhg on 16-3-14.
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
//        System.out.println("Standard Console::Logger: " + message);
        System.out.println("[" +getLevel(level) + "]: " + message);
    }
}
