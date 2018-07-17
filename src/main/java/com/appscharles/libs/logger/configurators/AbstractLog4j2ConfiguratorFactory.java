package com.appscharles.libs.logger.configurators;

import org.apache.logging.log4j.Level;

import java.util.HashMap;
import java.util.Map;


/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 03.07.2018
 * Time: 22:19
 * Project name: logger
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public abstract class AbstractLog4j2ConfiguratorFactory implements ILoggerConfiguratorFactory {

    protected String name;

    protected Level rootLevel;

    protected Map<String, Level> levelLoggers;

    public AbstractLog4j2ConfiguratorFactory(Level rootLevel) {
        this(null, rootLevel);
    }

    public AbstractLog4j2ConfiguratorFactory(String name, Level rootLevel) {
        this.name = name;
        this.rootLevel = rootLevel;
        this.levelLoggers = new HashMap<>();
    }

    public <T> T setLevel(String loggerName, Level level) {
        this.levelLoggers.put(loggerName, level);
        return (T) this;
    }
}
