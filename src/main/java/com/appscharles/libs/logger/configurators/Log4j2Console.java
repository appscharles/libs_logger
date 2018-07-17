package com.appscharles.libs.logger.configurators;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 03.07.2018
 * Time: 22:18
 * Project name: logger
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class Log4j2Console extends AbstractLog4j2ConfiguratorFactory {

    public Log4j2Console(String name, Level rootLevel) {
        super(name, rootLevel);
    }

    public Log4j2Console(Level rootLevel) {
        super(rootLevel);
    }

    @Override
    public void config() {
        System.setProperty("log4j2.loggerContextFactory", "org.apache.logging.log4j.core.impl.Log4jContextFactory");
        System.setProperty("log4j2Console.rootLevel", this.rootLevel.name());
        Configurator.initialize(this.name, "classpath:com/appscharles/libs/logger/xmls/Log4j2Console.xml");
        this.levelLoggers.forEach((loggerName, level)->{
            Configurator.setLevel(loggerName, level);
        });
    }

    public Log4j2Console setConsolePatternLayout(String pattern){
        System.setProperty("log4j2Console.consolePatternLayout", pattern);
        return this;
    }
}
