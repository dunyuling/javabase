package com.lhg.test.designpattern.chainofresponsibility;

/**
 * Created by liuhg on 16-3-14.
 */
public abstract class AbstractLogger {

//    public static int INFO = LoggerLevel.INFO.ordinal();
//    public static int DEBUG = LoggerLevel.DEBUG.ordinal();
//    public static int ERROR = LoggerLevel.ERROR.ordinal();

    enum LoggerLevel {
        INFO,DEBUG,ERROR;
    }

    protected String getLevel(int level) {
        switch (level) {
            case 1:
                return LoggerLevel.DEBUG.toString();
            case 2:
                return LoggerLevel.ERROR.toString();
        }
        return LoggerLevel.INFO.toString();
    }

    protected int level;

    protected AbstractLogger nextLogger;

    protected void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    protected void logMessage(int level,String message) {
        if (this.level <= level) {
            write(message);
        }
        if(nextLogger != null) {
            nextLogger.logMessage(level,message);
        }
    }

    protected abstract void write(String message);
}
