package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jRollingExample {

    private static final Logger logger =
            LogManager.getLogger(Log4jRollingExample.class);

    public static void main(String[] args) {

        logger.debug("DEBUG log - visible only for com.myapp");
        logger.info("INFO log");
        logger.warn("WARN log");
        logger.error("ERROR log");

        for (int i = 1; i <= 100; i++) {
            logger.info("Rolling test log number: " + i);
        }
    }
}
