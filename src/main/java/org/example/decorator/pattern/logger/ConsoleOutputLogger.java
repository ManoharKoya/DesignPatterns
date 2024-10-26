package org.example.decorator.pattern.logger;

public class ConsoleOutputLogger extends FilterLogOutput{
    ConsoleOutputLogger(Logger logger) {
        this.logger = logger;
    }
    public void log(String logMessage) {
        // write to Console configuration
        logMessage = "[Console] " + logMessage;
        this.logger.log(logMessage);
    }
}
