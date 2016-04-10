package sample.controllers;

import interfaces.SceneController;
import interfaces.StageController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.core.SceneManager;
import sample.core.StageManager;
import sample.enums.Scenes;
import sample.models.GameHighScore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertUsernameController extends AbstractController implements SceneController {
    private SceneManager sceneManager;

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
            String input = this.usernameTextField.getText();
            Pattern pattern = Pattern.compile("([a-zA-Z]+)[\\W]+([0-9]+)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String name = matcher.group(1);
                Integer points = Integer.parseInt(matcher.group(2));
                this.stageManager.gameDatabase.addHighScore(new GameHighScore(name, points));
            }
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
}
