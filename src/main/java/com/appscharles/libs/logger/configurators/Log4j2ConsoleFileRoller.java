package com.appscharles.libs.logger.configurators;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 03.07.2018
 * Time: 22:18
 * Project name: logger
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class Log4j2ConsoleFileRoller extends AbstractLog4j2ConfiguratorFactory {

    public Log4j2ConsoleFileRoller(Level rootLevel) {
        super(rootLevel);
    }

    public Log4j2ConsoleFileRoller(String name, Level rootLevel) {
        super(name, rootLevel);
    }

    @Override
    public void config() {
        System.setProperty("log4j2.loggerContextFactory", "org.apache.logging.log4j.core.impl.Log4jContextFactory");
        System.setProperty("log4j2ConsoleFileRoller.rootLevel", this.rootLevel.name());
        Configurator.initialize(this.name, "classpath:com/appscharles/libs/logger/xmls/Log4j2ConsoleFileRoller.xml");
        this.levelLoggers.forEach((loggerName, level)->{
            Configurator.setLevel(loggerName, level);
        });
    }


    public Log4j2ConsoleFileRoller setLogsDir(File logsDir) {
        System.setProperty("log4j2ConsoleFileRoller.logsDir", logsDir.getAbsolutePath());
        return this;
    }

    public Log4j2ConsoleFileRoller setConsolePatternLayout(String pattern) {
        System.setProperty("log4j2ConsoleFileRoller.consolePatternLayout", pattern);
        return this;
    }

    public Log4j2ConsoleFileRoller setRollingFilePatternLayout(String pattern) {
        System.setProperty("log4j2ConsoleFileRoller.rollingFilePatternLayout", pattern);
        return this;
    }
}
