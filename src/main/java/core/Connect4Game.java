package core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This the entry point of the application launch called by the main
 * <p>
 *     Inheriting from application requiring an implementation of abstract class start that allows the display of the view
 * </p>
 * @author Daniel R Bondyale Juez
 * @version 1.0
 */
public class Connect4Game extends Application {

    private Stage mainStage;

    /**
     * This is the constructor. The mainStage attribute is instantiate.
     */
    public Connect4Game() { mainStage = new Stage();}

    /**
     * This is the implementation of the start abstract method of the extended class Application.
     *  * <p>
     *     This method is called during the execution of the Application class static method launch. It loads the FXMl files,
     *     therefore, building its controllers too and the the built mainStage is displayed with the method show of the Stage class.
     *  * </p>
     * @param stage Stage object provided during the static launch method execution.
     */
    @Override
    public void start(Stage stage)  {
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
        if(root == null) {
            // This is the extreme case if loaded fxml file is null
            gracefulShutdown();
        } else {
            Scene newScene = new Scene(root);
            mainStage.setScene(newScene);
        }
    }
    private Parent loadPaneLoader(FXMLLoader paneLoader) {
        try {
            return paneLoader.load();
        } catch (IOException e) {
            //Todo: log!!
            System.out.println("The FXML file could not be loaded.");
            return null;
        }
    }

    private void gracefulShutdown(){
        // Show something to the user if apply
        // save a new log if a apply
        System.out.println("HERE");
        System.exit(-1);
    }

}
