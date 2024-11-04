package org.example.decorator.pattern.logger;

public class CloudOutputLoggerDecorator extends FilterLogOutputDecorator {
    CloudOutputLoggerDecorator(Logger logger) {
        this.logger = logger;
    }
    public void log(String logMessage) {
        // write to Cloud configuration
        logMessage = "[Cloud] " + logMessage;
        this.logger.log(logMessage);
    }
}
