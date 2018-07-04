package com.appscharles.libs.logger.configurators;

import com.appscharles.libs.logger.services.LoggerConfigurator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.IOException;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 03.07.2018
 * Time: 22:34
 * Project name: logger
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class Log4j2ConsoleLoaderTest {
    @Test
    public void shouldDisplayErrorInConsole() throws IOException, InterruptedException {

        Logger logger = LogManager.getLogger(Log4j2ConsoleFileRollerLoaderTest.class);
        logger.error("Error");

        LoggerConfigurator.config(new Log4j2Console(Level.ERROR).setLevel("com.appscharles", Level.DEBUG));
        logger.debug("Debug");
        LoggerConfigurator.config(new Log4j2Console(Level.DEBUG).setLevel("com.appscharles", Level.ERROR));

        logger.debug("Debug2");
    }
}