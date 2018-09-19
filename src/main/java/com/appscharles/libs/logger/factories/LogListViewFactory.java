package com.appscharles.libs.logger.factories;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.AbstractPrepareViewFactory;
import com.appscharles.libs.fxer.factories.FxViewFactory;
import com.appscharles.libs.fxer.views.FxView;
import com.appscharles.libs.logger.guis.list.LogListController;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The type Log list view factory.
 */
public class LogListViewFactory extends AbstractPrepareViewFactory {

    private List<String> stylesheets;

    private String alertDetailsLogResourceIcon;

    private ResourceBundle sectionsResourceBundle;

    /**
     * Instantiates a new Log list view factory.
     */
    public LogListViewFactory() {
        this.stylesheets = new ArrayList<>();
        this.stylesheets.add("com/appscharles/libs/logger/guis/list/styles/TableView.css");
    }

    public Parent create() throws FxerException {
        try {
            LogListController controller = new LogListController();
            controller.setSectionsResourceBundle(this.sectionsResourceBundle);
            controller.setAlertDetailsLogResourceIcon(this.alertDetailsLogResourceIcon);
            FxViewFactory factory = new FxViewFactory("/com/appscharles/libs/logger/guis/list/LogListView.fxml",
                    "com/appscharles/libs/logger/guis/list/translations/LogList",controller, this.fXStage);
            for (String stylesheet : this.stylesheets) {
                factory.addStylesheet(stylesheet);
            }
            FxView fxView = factory.create();

            return fxView.createView();
        } catch (IOException e) {
            throw new FxerException(e);
        }
    }

    /**
     * Add stylesheet log list view factory.
     *
     * @param stylesheet the stylesheet
     * @return the log list view factory
     */
    public LogListViewFactory addStylesheet(String stylesheet){
        this.stylesheets.add(stylesheet);
        return this;
    }

    /**
     * Sets alert details log resource icon.
     *
     * @param alertDetailsLogResourceIcon the alert details log resource icon
     * @return the alert details log resource icon
     */
    public LogListViewFactory setAlertDetailsLogResourceIcon(String alertDetailsLogResourceIcon) {
        this.alertDetailsLogResourceIcon = alertDetailsLogResourceIcon;
        return this;
    }

    /**
     * Setter for property 'sectionsResourceBundle'.
     *
     * @param sectionsResourceBundle Value to set for property 'sectionsResourceBundle'.
     */
    public LogListViewFactory setSectionsResourceBundle(ResourceBundle sectionsResourceBundle) {
        this.sectionsResourceBundle = sectionsResourceBundle;
        return this;
    }
}