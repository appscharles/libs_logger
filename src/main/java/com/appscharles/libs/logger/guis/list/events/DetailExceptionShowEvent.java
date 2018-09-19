package com.appscharles.libs.logger.guis.list.events;

import com.appscharles.libs.dialoger.factories.ExceptionDialogFactory;
import com.sun.javafx.application.PlatformImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The type Detail exception show event.
 */
public class DetailExceptionShowEvent implements EventHandler<ActionEvent> {

    private String title;

    private String contentText;

    private String exception;

    /**
     * Instantiates a new Detail exception show event.
     *
     * @param title       the title
     * @param contentText the content text
     * @param exception   the exception
     */
    public DetailExceptionShowEvent(String title, String contentText, String exception) {
        this.title = title;
        this.contentText = contentText;
        this.exception = exception;
    }

    @Override
    public void handle(ActionEvent event) {
        PlatformImpl.runAndWait(()->{
            ExceptionDialogFactory.create(this.title, this.contentText, null).setExceptionString(this.exception).build().showAndWait();
        });
    }
}
