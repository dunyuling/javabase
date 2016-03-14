package com.lhg.test.designpattern.chainofresponsibility;

/**
 * Created by liuhg on 16-3-14.
 */
public class ChainPatternDemo {
    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.LoggerLevel.ERROR.ordinal());
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.LoggerLevel.DEBUG.ordinal());
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.LoggerLevel.INFO.ordinal());

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.LoggerLevel.INFO.ordinal(),
                "This is an information.");
        System.out.println();

        loggerChain.logMessage(AbstractLogger.LoggerLevel.DEBUG.ordinal(),
                "This is an debug level information.");
        System.out.println();

        loggerChain.logMessage(AbstractLogger.LoggerLevel.ERROR.ordinal(),
                "This is an error information.");
    }
}
