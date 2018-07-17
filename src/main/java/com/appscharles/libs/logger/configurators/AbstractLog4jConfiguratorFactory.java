package com.appscharles.libs.logger.configurators;


import org.apache.log4j.Level;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 03.07.2018
 * Time: 22:19
 * Project name: logger
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public abstract class AbstractLog4jConfiguratorFactory implements ILoggerConfiguratorFactory {

    protected String name;

    protected Level rootLevel;

    public AbstractLog4jConfiguratorFactory(Level rootLevel) {
        this(null, rootLevel);
    }

    public AbstractLog4jConfiguratorFactory(String name, Level rootLevel) {
        this.name = name;
        this.rootLevel = rootLevel;
    }

}
