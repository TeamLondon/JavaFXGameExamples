package sample.controllers;

import interfaces.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.core.StageManager;
import sample.enums.Scenes;

public class HighScoreController extends AbstractController {
    public ScrollPane highScoreScrollPane;

    public Label highScoreResultsLabel;

    @FXML
    private Button mainMenuButton;

    @FXML
    private Label highScoreLabel;

    @Override
    public void setStageManager(StageManager stageManager) {
        super.setStageManager(stageManager);
        this.initializeInfo();
    }

    public void onMenuButtonClick() {
        this.stageManager.setScene(Scenes.StartGameScene);
    }

    private void initializeInfo() {
        String highScoreText = this.gameDatabase.getHighScore();
        this.highScoreResultsLabel.setText(highScoreText);
    }

    @FXML
    public void onMenuButtonKeyPress(KeyEvent k) {
        if (k.getCode() == KeyCode.ENTER) {
            this.onMenuButtonClick();
        }
    }
}
