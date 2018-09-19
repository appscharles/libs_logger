package com.appscharles.libs.logger.repositories;


import com.appscharles.libs.databaser.exceptions.DatabaserException;
import com.appscharles.libs.databaser.operators.DBOperator;
import com.appscharles.libs.logger.models.Log;
import com.appscharles.libs.logger.models.enums.LevelLog;
import extensions.DatabaseInitializeTest;
import extensions.LoggerInitializeTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The type Log repository test.
 */
@LoggerInitializeTest
@DatabaseInitializeTest
public class LogRepositoryTest {

    /**
     * Should remove all logs.
     *
     * @throws DatabaserException the databaser exception
     * @throws IOException        the io exception
     */
    @Test
    public void shouldRemoveAllLogs() throws DatabaserException {
        LogRepository.removeAll();
        DBOperator.save(new Log("Message", LevelLog.ERROR, "sectionName"));
        DBOperator.save(new Log("Message2", LevelLog.ERROR, "sectionName"));
        assertTrue(DBOperator.getAll(Log.class).size() == 2);
        LogRepository.removeAll();
        assertTrue(DBOperator.getAll(Log.class).size() == 0);
    }

}