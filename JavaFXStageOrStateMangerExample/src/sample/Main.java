package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.controllers.StageManager;
import sample.enums.Scenes;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
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

        StageManager stageManager = new StageManager(primaryStage);
        stageManager.setScene(Scenes.StartGameScene);
        primaryStage.setTitle("Cosmic fight");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
