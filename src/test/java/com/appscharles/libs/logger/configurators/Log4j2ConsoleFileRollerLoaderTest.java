package com.appscharles.libs.logger.configurators;

import com.appscharles.libs.ioer.services.FileReader;
import com.appscharles.libs.logger.services.LoggerConfigurator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

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
    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    @Test
    public void shouldDisplayErrorInConsole() throws IOException, InterruptedException {
        File logsDir =  this.temp.newFolder();

        LoggerConfigurator.config(new Log4j2ConsoleFileRoller(Level.DEBUG).setLogsDir(logsDir));

        Logger logger = LogManager.getLogger(Log4j2ConsoleFileRollerLoaderTest.class);
        logger.error("Error", new IOException("Error"));

        File file = new File(logsDir, "logs.log");
        Assert.assertTrue(file.exists());
        Thread.sleep(2000);
        Assert.assertTrue(FileReader.read(file).contains("Error"));
        System.out.println(FileReader.read(file));

    }
}