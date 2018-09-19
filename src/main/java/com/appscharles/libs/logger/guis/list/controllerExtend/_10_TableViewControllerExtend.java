package com.appscharles.libs.logger.guis.list.controllerExtend;

import com.appscharles.libs.databaser.operators.DBOperator;
import com.appscharles.libs.fxer.tables.cells.UniversalTableCell;
import com.appscharles.libs.logger.guis.list.events.DetailExceptionShowEvent;
import com.appscharles.libs.logger.models.Log;
import com.google.common.collect.Lists;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * The type 10 table view controller extend.
 */
public class _10_TableViewControllerExtend extends _6_ResourceIconControllerExtend {

    /**
     * The Table.
     */
    @FXML
    protected TableView<Log> table;

    @FXML
    protected TableColumn<Log, Node> columnLevel;

    /**
     * The Column created at.
     */
    @FXML
    protected TableColumn<Log, Calendar> columnCreatedAt;

    /**
     * The Column name scheduler.
     */
    @FXML
    protected TableColumn<Log, Node> columnSection;

    /**
     * The Column message.
     */
    @FXML
    protected TableColumn<String, Log> columnMessage;

    @FXML
    protected TableColumn<Log, Node> columnException;

    /**
     * The Logs.
     */
    protected ObservableList<Log> logs;

    /**
     * Instantiates a new 10 table view controller extend.
     */
    protected _10_TableViewControllerExtend() {
        this.addOnInitializeWithSneakyThrow(() -> {
            this.logs = FXCollections.observableArrayList();
            this.table.setItems(this.logs);
        });

        this.addOnInitializeWithSneakyThrow(() -> {
            this.columnLevel.setCellFactory(new UniversalTableCell<Log, Node>().forTableColumn((Node node, Log log) -> {
                String text;
                if (this.resourceBundle.containsKey("view.table.label.level_" + log.getLevel().name().toLowerCase())){
                    text = this.resourceBundle.getString("view.table.label.level_" + log.getLevel().name().toLowerCase());
                } else {
                    text = log.getLevel().name();
                }
                return new Label(text);
            }));
            this.columnMessage.setCellValueFactory(new PropertyValueFactory<>("message"));
            this.columnSection.setCellFactory(new UniversalTableCell<Log, Node>().forTableColumn((Node node, Log log) -> {
               String text;
               if (this.sectionsResourceBundle != null && this.sectionsResourceBundle.containsKey("view.table.label.section_" + log.getSection().toLowerCase())){
                   text = this.sectionsResourceBundle.getString("view.table.label.section_" + log.getSection().toLowerCase());
               } else {
                   text = log.getSection().toLowerCase();
               }
               return new Label(text);
            }));
            this.columnCreatedAt.setCellFactory(new UniversalTableCell<Log, Calendar>().forTableColumn((Calendar calendar, Log log) -> {
                return new Label(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(log.getCreatedAt().getTime()));
            }));
            this.columnException.setCellFactory(new UniversalTableCell<Log, Node>().forTableColumn((Node node, Log log) -> {
                if (log.getException() != null){
                    Button button = new Button(this.resourceBundle.getString("view.table.button.details"));
                    button.setOnAction(new DetailExceptionShowEvent(this.resourceBundle.getString("alert.error.title.detail_error"), log.getMessage(), log.getException()));
                    return button;
                }
                return new Label();
            }));
        });
        this.addOnInitializeWithSneakyThrow(() -> {
            loadLogs();
        });
    }

    /**
     * Load logs.
     */
    protected void loadLogs() {
        sneakyThrow(() -> {
            this.logs.clear();
            this.logs.addAll(Lists.reverse(DBOperator.getAll(Log.class)));
        });
    }
}
