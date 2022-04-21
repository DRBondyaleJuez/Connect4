package viewController;

import controller.Connect4GridController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.net.URISyntaxException;

public class Connect4Grid {

    private GridPane grid;
    private ImageView[][] imageViewGrid;
    private Connect4GridController gridController;
    private GameViewController gameController;
    private boolean winner;

    public Connect4Grid(int row, int col, GameViewController gameController) {

        grid = gridCreator(row, col);
        gridController = new Connect4GridController();
        this.gameController = gameController;
        winner = false;
    }

    private GridPane gridCreator(int row, int col){

        GridPane grid = new GridPane();
        imageViewGrid = new ImageView[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                imageViewGrid[i][j] = new ImageView();

                // Setting the empty initial image
                ImageView currentImageView = imageViewGrid[i][j];

                try {
                    Image imgEmptyGrid = new Image(getClass().getResource("/view/images/empty.png").toURI().toString());
                    currentImageView.setImage(imgEmptyGrid);
                } catch (URISyntaxException e) {
                    System.out.println("Malformed URI");
                    e.printStackTrace();
                }

                // Setting the action
                currentImageView.setOnMouseClicked(cellClicked(i));

                // Adding to the gridPane
                grid.add(currentImageView,i,j);


            }

        }


        return grid;

    }

    private EventHandler<MouseEvent> cellClicked(int rowPosition){
        return new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent){
                if(winner == false) {
                    if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                        int playingPlayer = gridController.getPlayer();
                        int chipPlayedInColumnPosition = gridController.cellClicked(rowPosition);
                        if (chipPlayedInColumnPosition > -1) {
                            try {
                                Image imgFullGrid = new Image(getClass().getResource("/view/images/full1.png").toURI().toString());
                                if (playingPlayer == 2) {
                                    imgFullGrid = new Image(getClass().getResource("/view/images/full2.png").toURI().toString());
                                }
                                imageViewGrid[rowPosition][chipPlayedInColumnPosition].setImage(imgFullGrid);
                            } catch (URISyntaxException e) {
                                System.out.println("Malformed URI");
                                e.printStackTrace();
                            }

                            //Change game labels if needed

                            //Winner Label
                            if (gridController.isThereAWinner()) {
                                gameController.changeWinnerLabel(playingPlayer);
                                winner = true;
                            } else {
                                //Turn label
                                gridController.changePlayer();
                                gameController.changeTurnLabel(gridController.getPlayer());
                                gameController.changeTurnImageView(gridController.getPlayer());
                            }


                        }

                    }
                }
            }
        };
    }

    public GridPane getGrid() { return grid;}




}
