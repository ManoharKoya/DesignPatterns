package org.example.decorator.pattern.logger;

public class FileOutputLoggerDecorator extends FilterLogOutputDecorator {
    FileOutputLoggerDecorator(Logger logger) {
        this.logger = logger;
    }
    public void log(String logMessage) {
        // write to File configuration
        logMessage = "[File] " + logMessage;
        this.logger.log(logMessage);
    }
}
