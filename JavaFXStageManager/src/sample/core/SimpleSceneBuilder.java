package sample.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.controllers.HighScoreController;
import sample.controllers.InsertUsernameController;
import sample.controllers.StartGameController;
import sample.enums.Scenes;
import utils.Constants;

import java.io.IOException;

public class SimpleSceneBuilder {
    private FXMLLoader myLoader;

    public SimpleSceneBuilder() {
    }

    public Scene build(Scenes sceneType, StageManager stageManager){
        Scene scene = null;
        switch (sceneType){
            case StartGameScene:
                scene = getStartScene(stageManager);
                break;
            case InsertUsernameScene:
                scene = getInsertUsernameScene(stageManager);
                break;
            case HighScoreScene:
                scene = getHighScoreScene(stageManager);
            default:
                break;
        }

        return scene;
    }

    private Scene getHighScoreScene(StageManager stageManager) {
        Scene scene = null;
        this.myLoader = new FXMLLoader(getClass().getResource(Constants.HighScoreSceneResource));
        try {
            Parent loadScreen = this.myLoader.load();
            scene = new Scene(loadScreen);

            HighScoreController highScoreController = this.myLoader.getController();
            highScoreController.setStageManager(stageManager);

        } catch (IOException e) {
            // Alert.show("Scene not loaded.");
            System.out.println(e.getMessage());
        }
        return scene;
    }

    private Scene getInsertUsernameScene(StageManager stageManager) {
        Scene scene = null;
        this.myLoader = new FXMLLoader(getClass().getResource(Constants.InsertUsernameSceneResource));
        try {
            Parent loadScreen = this.myLoader.load();
            scene = new Scene(loadScreen);

            InsertUsernameController insertUsernameController = this.myLoader.getController();
            insertUsernameController.setStageManager(stageManager);
        } catch (IOException e) {
            // Alert.show("Scene not loaded.");
        }
        return scene;
    }

    private Scene getStartScene(StageManager stageManager) {
        Scene scene = null;
        this.myLoader = new FXMLLoader(getClass().getResource(Constants.StartGameSceneResource));
        try {
            Parent loadScreen = this.myLoader.load();
            scene = new Scene(loadScreen);
            StartGameController startGameController = this.myLoader.getController();
            startGameController.setStageManager(stageManager);
        } catch (IOException e) {
            // Alert.show("Scene not loaded.");
        }
        return scene;
    }
}
