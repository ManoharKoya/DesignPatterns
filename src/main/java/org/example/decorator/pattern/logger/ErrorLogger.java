package org.example.decorator.pattern.logger;

public class ErrorLogger extends Logger{
    public void log(String logMessage) {
        System.out.printf("[Error] -[DateTime] - %s\n", logMessage);
    }

}
