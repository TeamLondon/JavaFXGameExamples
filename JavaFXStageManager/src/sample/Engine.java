package sample;

import interfaces.Database;
import javafx.application.Application;
import javafx.stage.Stage;
import sample.core.GameDatabase;
import sample.core.SimpleSceneBuilder;
import sample.core.StageManager;
import sample.enums.Scenes;

public class Engine extends Application {
    private StageManager stageManager;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initialize(primaryStage);

        primaryStage.show();
    }

    private void initialize(Stage primaryStage) throws java.io.IOException {
        /*
        SceneManager sceneManager = new SceneManager();
        sceneManager.loadScene(Constants.StartGameSceneID, Constants.StartGameSceneResource);
        sceneManager.loadScene(Constants.InsertUsernameSceneID, Constants.InsertUsernameSceneResource);

        sceneManager.setScene(Constants.StartGameSceneID);

        Group root = new Group();
        root.getChildren().addAll(sceneManager);
        Scene scene = new Scene(root, Constants.SceneWidth, Constants.SceneHeight);

        primaryStage.setScene(scene);
        */

        SimpleSceneBuilder sceneBuilder = new SimpleSceneBuilder();
        Database gameDatabase = new GameDatabase();
        this.stageManager = new StageManager(primaryStage, sceneBuilder, gameDatabase);

        this.stageManager.setScene(Scenes.StartGameScene);
        primaryStage.setTitle("Cosmic fight");
    }
}
