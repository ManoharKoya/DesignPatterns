package org.example.decorator.pattern.logger;

public class Main {
    public static void main(String args[]) {
        Logger logger = new InfoLogger();
        logger = new CloudOutputLogger(logger);
        logger.log("Some Info message which goes to Cloud");

        logger = new FileOutputLogger(new DebugLogger());
        logger.log("Some Debug message which goes to File");
    }
}
