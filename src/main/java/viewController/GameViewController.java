package viewController;

import core.Connect4Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Provides the initializable object in charged of acting as viewController of the view section that correspond to the
 * game that is not the grid of cells.
 * <p>
 *     This viewController handles changes in the display of player turn and winner information of the view. It also
 *     handles user interactions with the restart button.
 *     The implementation of initializable interface is required to properly serve as the assigned controller of a view.
 * </p>
 * @author Daniel R Bondyale Juez
 * @version 1.0
 */
public class GameViewController implements Initializable{

    private static Logger logger = LogManager.getLogger(GameViewController.class);
    @FXML
    private BorderPane gameBorderPane;

    @FXML
    private Label turnLabel;

    @FXML
    private Label winnerLabel;

    @FXML
    private ImageView turnImageView;


    /**
     * This is the implementation of the initialize abstract method.
     *  * <p>
     *     Before the view is displayed, the grid is built instantiating a Connect4Grid object and then set in the GameView
     *     BorderPane centre. This method is invoked during the FXMLLoader class' load method
     *  * </p>
     * @param url URL object provided during FXMLLoader's load method.
     * @param resourceBundle ResourceBundle object provided during FXMLLoader's load method.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connect4Grid newConnect4Grid = new Connect4Grid(6,7,this);
        addConnect4Grid(newConnect4Grid.getGrid());
        changeTurnImageView(1);
    }

    private void addConnect4Grid(GridPane connect4Grid){

        gameBorderPane.setCenter(connect4Grid);

    }

    /**
     * This changes the displayed section of the view showing the current player's turn.
     *  * <p>
     *     This method is instantiated by the observed Connect4Grid when a user's interaction has caused changes
     *     starting a new turn for the other player.
     *  * </p>
     * @param player int corresponding to the player who currently should play, this is, interact with the view.
     */
    public void changeTurnDisplay(int player){
        turnLabel.setText("Turn for Player " + player);
        changeTurnImageView(player);
    }
    private void changeTurnImageView(int player){

        Image chipImage = getImageFromResources("/view/images/chip1.png");
        if(player == 2) {
            chipImage = getImageFromResources("/view/images/chip2.png");
        }
        turnImageView.setImage(chipImage);
    }

    /**
     * This changes the displayed section of the view showing if there has been a tie, a player has won or the game should continue.
     *  * <p>
     *     This method is instantiated by the observed Connect4Grid when a winner has been identified.
     *  * </p>
     * @param player int corresponding to the player who has won.
     */
    public void changeWinnerLabel(int player){
        winnerLabel.setText("THE WINNER IS: PLAYER " + player);
        turnLabel.setText("Player " + player + " wins.");
        if(player == 1) {
            turnLabel.setTextFill(Color.color(1, 0, 0));
            winnerLabel.setTextFill(Color.color(1,0,0));
        }else {
            turnLabel.setTextFill(Color.color(0.9, 0.7, 0.1));
            winnerLabel.setTextFill(Color.color(0.9, 0.7, 0.1));
        }
    }

    /**
     * This FXML annotated method corresponds to a method in the GameView.fxml file it handles the onAction event of
     * the restart button present in the game view. It causes the view to return to the initial state of the game with the empty grid.
     * <p>
     *     Calls all methods necesary to reset the game in its initial state. With the grid empty, player 1's turn and with no winner.
     * </p>
     */
    @FXML
    public void restartButtonAction(){
        Connect4Grid newConnect4Grid = new Connect4Grid(6,7,this);
        addConnect4Grid(newConnect4Grid.getGrid());
        changeTurnImageView(1);
        turnLabel.setText("Turn for Player 1");
        turnLabel.setTextFill(Color.color(0, 0, 0));
        winnerLabel.setText("Keep playing there has not been a winner yet ...");
        winnerLabel.setTextFill(Color.color(0, 0, 0));
    }

    private Image getImageFromResources(String path){
        try {
            InputStream imageInputStream = Connect4Grid.class.getResourceAsStream(path);
            if(imageInputStream == null){
                throw new IOException();
            }
            return new Image(new ByteArrayInputStream(IOUtils.toByteArray(imageInputStream)));
        } catch (IOException exception) {
            logger.error("Could not find image at path: " + path + ". It could not be loaded. ERROR:\n ",  exception);
            return null;
        }
    }
}
