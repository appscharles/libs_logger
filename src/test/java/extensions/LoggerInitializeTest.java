package extensions;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.09.2018
 * Time: 10:41
 * Project name: stocker
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(LoggerInitializeExtensionTest.class)
public @interface LoggerInitializeTest {

}