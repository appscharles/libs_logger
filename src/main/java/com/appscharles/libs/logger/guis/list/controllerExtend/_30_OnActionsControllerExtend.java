package com.appscharles.libs.logger.guis.list.controllerExtend;

import com.appscharles.libs.dialoger.factories.AlertConfirmationFactory;
import com.appscharles.libs.logger.repositories.LogRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * The type 30 on actions controller extend.
 */
public class _30_OnActionsControllerExtend extends _10_TableViewControllerExtend {

    /**
     * Refresh.
     */
    @FXML
    public void cancel(){
       this.fxStage.close();
    }

    @FXML
    public void refresh(){
        loadLogs();
    }

    @FXML
    public void remove(){
        AlertConfirmationFactory factory = AlertConfirmationFactory.create(Alert.AlertType.CONFIRMATION, this.resourceBundle.getString("alert.confirmation.title"), this.resourceBundle
                .getString("alert.confirmation.content.want_to_delete_logs"));
        if (this.alertDetailsLogResourceIcon != null){
            factory.setIconStageResource(this.alertDetailsLogResourceIcon);
        }
        Optional<ButtonType> result = factory.build().showAndWait();
        if (result.get() == factory.getButtonTypeYes()){
            sneakyThrow(()->{
                LogRepository.removeAll();
                loadLogs();
            });
        }
    }
}
