package com.appscharles.libs.logger.guis.list;

import com.appscharles.libs.databaser.exceptions.DatabaserException;
import com.appscharles.libs.databaser.operators.DBOperator;
import com.appscharles.libs.dialoger.converters.ExceptionConverter;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.guis.popup.PopupStage;
import com.appscharles.libs.logger.factories.LogListViewFactory;
import com.appscharles.libs.logger.models.Log;
import com.appscharles.libs.logger.models.enums.LevelLog;
import com.sun.javafx.application.PlatformImpl;
import extensions.DatabaseInitializeTest;
import extensions.LoggerInitializeTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * The type Logs controller test.
 */
@LoggerInitializeTest
@DatabaseInitializeTest
public class LogsControllerTest {

    /**
     * Should open stage.
     *
     * @throws FxerException      the fxer exception
     * @throws DatabaserException the databaser exception
     */
    @Test
    public void shouldOpenStage() throws FxerException, DatabaserException {
        PlatformImpl.startup(()->{});
        DBOperator.save(new Log("Message", LevelLog.ERROR, "sectionName", ExceptionConverter.toString(new IOException("Failed"))));
        LogListViewFactory viewFactory = new LogListViewFactory();
       new PopupStage(viewFactory).setWithWait(true).showFx();
    }
}