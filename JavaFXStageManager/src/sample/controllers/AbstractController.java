package sample.controllers;

import interfaces.Database;
import interfaces.StageController;
import sample.core.StageManager;

public abstract class AbstractController implements StageController {
    protected StageManager stageManager;

    protected Database gameDatabase;

    @Override
    public void setStageManager(StageManager stageManager) {
        this.gameDatabase = stageManager.gameDatabase;
        this.stageManager = stageManager;
        this.stageManager.stage.setOnCloseRequest(e -> {
            e.consume();
            this.onCloseRequest();
        });
    }

    public void onCloseRequest() {
        this.gameDatabase.saveHighScoreInfo();
        System.out.println("Data saved.");
        this.stageManager.stage.close();
    }
}
