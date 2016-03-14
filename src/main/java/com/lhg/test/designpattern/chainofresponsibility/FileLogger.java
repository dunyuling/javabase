package com.lhg.test.designpattern.chainofresponsibility;

/**
 * Created by liuhg on 16-3-14.
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        /*System.out.println("File Console::Logger: " + message);*/
        System.out.println("[" +getLevel(level) + "]: " + message);
    }
}
