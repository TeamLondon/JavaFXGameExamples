package sample.core;

import interfaces.Database;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.enums.Scenes;

public class StageManager {
    private SimpleSceneBuilder sceneBuilder;

    private Scene currentScene;

    public Stage stage;

    public Database gameDatabase;

    public StageManager(Stage stage, SimpleSceneBuilder sceneBuilder, Database gameDatabase) {
        this.stage = stage;
        this.sceneBuilder = sceneBuilder;
        this.gameDatabase = gameDatabase;
    }

    public SimpleSceneBuilder getSceneBuilder() {
        return sceneBuilder;
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public void setScene(Scenes sceneType) {
        Scene scene = sceneBuilder.build(sceneType, this);
        this.currentScene = scene;
        this.stage.setScene(scene);
    }

}
