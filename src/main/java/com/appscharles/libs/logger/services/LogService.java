package com.appscharles.libs.logger.services;

import com.appscharles.libs.databaser.exceptions.DatabaserException;
import com.appscharles.libs.databaser.operators.DBOperator;
import com.appscharles.libs.fxer.exceptions.ThrowingConsumer;
import com.appscharles.libs.logger.models.Log;
import com.appscharles.libs.logger.models.enums.LevelLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Log service.
 */
public class LogService {

    /**
     * Add error log.
     *
     * @param logMessage       the log message
     * @param logSection       the log section
     * @param aClassLogger     the a class logger
     * @param throwingConsumer the throwing consumer
     */
    public static void withErrorLog(String logMessage, String logSection, Class aClassLogger, ThrowingConsumer<Exception> throwingConsumer){
        final Logger logger = LogManager.getLogger(aClassLogger);
        try {
            throwingConsumer.accept();
        } catch (Exception e) {
            logger.error(e, e);
            try {
                DBOperator.save(new Log(logMessage, LevelLog.ERROR, logSection));
            } catch (DatabaserException e1) {
                logger.error(e1, e1);
            }
        }
    }
}
