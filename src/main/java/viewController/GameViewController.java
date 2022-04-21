package viewController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.beans.EventHandler;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameViewController implements Initializable{

    @FXML
    private BorderPane gameBorderPane;

    @FXML
    private Label turnLabel;

    @FXML
    private Label winnerLabel;

    @FXML
    private Button restartButton;

    @FXML
    private ImageView turnImageView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connect4Grid newConnect4Grid = new Connect4Grid(7,6,this);
        addConnect4Grid(newConnect4Grid.getGrid());
        changeTurnImageView(1);
    }

    public void addConnect4Grid(GridPane connect4Grid){

        gameBorderPane.setCenter(connect4Grid);

    }

    public void changeTurnLabel(int player){
        turnLabel.setText("Turn for Player " + player);
    }

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

    @FXML
    public void restartButtonAction(){
        Connect4Grid newConnect4Grid = new Connect4Grid(7,6,this);
        addConnect4Grid(newConnect4Grid.getGrid());
        changeTurnImageView(1);
        turnLabel.setText("Turn for Player 1");
        turnLabel.setTextFill(Color.color(0, 0, 0));
        winnerLabel.setText("Keep playing there has not been a winner yet ...");
        winnerLabel.setTextFill(Color.color(0, 0, 0));
    }

    public void changeTurnImageView(int player){

        try {
                Image chipImage = new Image(getClass().getResource("/view/images/chip1.png").toURI().toString());
            if(player == 2) {
                chipImage = new Image(getClass().getResource("/view/images/chip2.png").toURI().toString());
            }
            turnImageView.setImage(chipImage);
        } catch (URISyntaxException e) {
            System.out.println("Malformed URI");
            e.printStackTrace();
        }
    }


}
