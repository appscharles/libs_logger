package com.appscharles.libs.logger.guis.list.controllerExtend;


import javafx.application.Platform;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 22.08.2018
 * Time: 15:33
 * Project name: stocker
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class _50_StageControllerExtend extends _30_OnActionsControllerExtend {

    /**
     * Instantiates a new Signer list controller.
     */
    protected  _50_StageControllerExtend() {
        this.addOnInitialize(resourceBundle -> {
            Platform.runLater(() -> {
                this.fxStage.setTitle(this.resourceBundle.getString("stage.title"));
            });
        });
    }
}
