package org.example.decorator.pattern.logger;

public class CloudOutputLogger extends FilterLogOutput{
    CloudOutputLogger(Logger logger) {
        this.logger = logger;
    }
    public void log(String logMessage) {
        // write to Cloud configuration
        logMessage = "[Cloud] " + logMessage;
        this.logger.log(logMessage);
    }
}
