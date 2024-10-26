package org.example.decorator.pattern.logger;

public class InfoLogger extends Logger {
    public void log(String logMessage) {
        System.out.printf("[Info] - [DateTime] - %s\n", logMessage);
    }
}
