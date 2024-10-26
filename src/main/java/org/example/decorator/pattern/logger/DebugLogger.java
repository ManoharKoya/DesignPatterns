package org.example.decorator.pattern.logger;

public class DebugLogger extends Logger{
    public void log(String logMessage) {
        System.out.printf("[Debug] -[DateTime] - %s\n", logMessage);
    }

}
