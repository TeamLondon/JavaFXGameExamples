package sample.controllers;

import interfaces.SceneController;
import interfaces.StageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.enums.Scenes;
import utils.Constants;

public class InsertUsernameController implements SceneController, StageController {
    private SceneManager sceneManager;

    private StageManager stageManager;

    public TextField usernameTextField;

    public Button enterUsernameButton;

    public void onEnterUsernameButtonClick(){
        setNextScene();
    }

    @FXML
    public void onEnterUsernameKeyPressed(KeyEvent e)
    {
        if(e.getCode() == KeyCode.ENTER)
        {
            setNextScene();
        }
    }

    @Override
    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    private void setNextScene() {
        //this.sceneManager.setScene(Constants.StartGameSceneID);
        this.stageManager.setScene(Scenes.StartGameScene);
    }

    @Override
    public void setStageManager(StageManager stageManager) {
        this.stageManager = stageManager;
    }
}
