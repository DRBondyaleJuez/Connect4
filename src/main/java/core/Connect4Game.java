package core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import viewController.Connect4Grid;
import viewController.GameViewController;

import java.io.IOException;

public class Connect4Game extends Application {

    private Stage mainStage;

    public Connect4Game() { mainStage = new Stage();}

    @Override public void start(Stage stage)  throws Exception {
        mainStage = stage;
        loadingMainScene();

        mainStage.setTitle("Connect 4");
        mainStage.centerOnScreen();
        mainStage.show();
    }

    private void loadingMainScene() {
        // TO access to the Resource folder, you have to do the following:
        // getClass().getResource("/path/of/the/resource")
        FXMLLoader paneLoader = new FXMLLoader(getClass().getResource("/view/GameView.fxml"));
        Parent root = loadPaneLoader(paneLoader);
        Scene newScene = new Scene(root);
        mainStage.setScene(newScene);

    }

    private Parent loadPaneLoader(FXMLLoader paneLoader) {
        try {
            return paneLoader.load();
        } catch (IOException e) {
            //Todo: log!!
            //Todo do something if the try fails
            System.out.println("FAIL!!! EXPLOTION!!!! BOOOOOOM");
            System.out.println(e);
            return null;
        }
    }

}
