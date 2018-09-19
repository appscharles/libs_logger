package extensions;

import com.appscharles.libs.databaser.exceptions.DatabaserException;
import com.appscharles.libs.databaser.factories.DBSessionFactory;
import com.appscharles.libs.databaser.factories.ISessionFactory;
import com.appscharles.libs.databaser.managers.SFManager;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Properties;

/**
 * The type Database initialize extension test.
 */
public class DatabaseInitializeExtensionTest implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) throws DatabaserException {
        if (SFManager.existSessionFactory("default") == false){
            String databaseUrl = "jdbc:h2:mem:logger";
            Properties props = new Properties();
            props.put("hibernate.connection.driver_class", "org.h2.Driver");
            props.put("hibernate.connection.url", databaseUrl);
            props.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            props.put("hibernate.hbm2ddl.auto", "create");
            Configuration configuration = new Configuration().addProperties(props);
            ISessionFactory sessionFactory = new DBSessionFactory(configuration);
            sessionFactory.addPackageToScan("com.appscharles.libs.logger");
            SFManager.addSessionFactory("default", sessionFactory, true);
        }
    }
}