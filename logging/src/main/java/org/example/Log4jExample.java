package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jExample {

    private static final Logger logger = LogManager.getLogger(Log4jExample.class);

    public static void main(String[] args) {

        logger.trace("This is TRACE level log");
        logger.debug("This is DEBUG level log");
        logger.info("This is INFO level log");
        logger.warn("This is WARN level log");
        logger.error("This is ERROR level log");
        logger.fatal("This is FATAL level log");

        try {
            int result = 10 / 0;
        } catch (Exception e) {
            logger.error("Exception occurred", e);
        }
    }
}
