package com.appscharles.libs.logger.services;

import com.appscharles.libs.logger.configurators.ILoggerConfiguratorFactory;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 04.07.2018
 * Time: 14:49
 * Project name: logger
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class LoggerConfigurator {

    public static void config(ILoggerConfiguratorFactory loggerConfiguratorFactory){
        loggerConfiguratorFactory.config();
    }
}
