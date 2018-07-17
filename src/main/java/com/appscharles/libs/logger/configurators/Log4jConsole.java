package com.appscharles.libs.logger.configurators;


import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 03.07.2018
 * Time: 22:18
 * Project name: logger
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class Log4jConsole extends AbstractLog4jConfiguratorFactory {

    public Log4jConsole(String name, Level rootLevel) {
        super(name, rootLevel);
    }

    public Log4jConsole(Level rootLevel) {
        super(rootLevel);
    }

    @Override
    public void config() {
        ConsoleAppender console = new ConsoleAppender();
        String PATTERN = "%-5p %d [%t] %l %m%n";
        console.setLayout(new PatternLayout(PATTERN));
        console.setThreshold(this.rootLevel);
        console.activateOptions();
        Logger.getRootLogger().addAppender(console);
    }

}
