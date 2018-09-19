package extensions;

import com.appscharles.libs.logger.configurators.Log4j2Console;
import com.appscharles.libs.logger.configurators.Log4jConsole;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.logging.Logger;

/**
 * The type App initialize extension.
 */
public class LoggerInitializeExtensionTest implements BeforeAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) {
        new Log4j2Console(Level.WARN).config();
        new Log4jConsole(org.apache.log4j.Level.ERROR).config();

        Logger logger = Logger.getLogger("org.flywaydb.core");
        logger.setLevel(java.util.logging.Level.SEVERE);

    }
}