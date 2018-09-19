package com.appscharles.libs.logger.configurators;

import com.appscharles.libs.ioer.services.FileReader;
import com.appscharles.libs.logger.services.LoggerConfigurator;
import extensions.TemporaryFolderExtensionTest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 03.07.2018
 * Time: 22:29
 * Project name: logger
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class Log4j2ConsoleFileRollerLoaderTest {

    @RegisterExtension
    public TemporaryFolderExtensionTest temp = new TemporaryFolderExtensionTest();

    @Test
    public void shouldDisplayErrorInConsole() throws IOException, InterruptedException {
        File logsDir =  this.temp.newFolder();

        LoggerConfigurator.config(new Log4j2ConsoleFileRoller(Level.DEBUG).setLogsDir(logsDir));

        Logger logger = LogManager.getLogger(Log4j2ConsoleFileRollerLoaderTest.class);
        logger.error("Error", new IOException("Error"));

        File file = new File(logsDir, "logs.log");
        assertTrue(file.exists());
        Thread.sleep(2000);
        assertTrue(FileReader.read(file).contains("Error"));
        System.out.println(FileReader.read(file));

    }
}