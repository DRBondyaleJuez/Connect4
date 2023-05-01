package viewController;

import org.apache.commons.io.IOUtils;
import controller.Connect4GridController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Provides the object in charged of building and managing the view section that correspond to the connect4 grid.
 * <p>
 *     This view grid corresponds to the visual representation of the matrix of cells that form the bord. It corresponds
 *     to the view part of a model-view-controller design pattern. Interactions with elements of this section of the view
 *     trigger response calculated by its corresponding controller, this is, the Connect4GridController. For example:
 *     during player ones turn clicking on a pane of the grid pane displaying an image showing the state of the cell would
 *     trigger changes in the corresponding Board object and based on this changes the GridPane and GameView.
 * </p>
 * @author Daniel R Bondyale Juez
 * @version 1.0
 */
public class Connect4Grid {

    private final GridPane grid;
    private ImageView[][] imageViewGrid;
    private final Connect4GridController gridController;
    private final GameViewController gameController;
    private boolean winner;

    /**
     * This is the constructor. Based on the number of rows and columns this constructs this grid attribute which is a GridPane.
     * @param row number of rows in the board and therefore in the grid of the view.
     * @param col number of columns in the board and therefore in the grid of the view.
     * @param gameController a GameViewController object which corresponds to the viewController that manages the rest of the view
     *                       besides the grid of cells. The communication between this classes is necessary to perform changes in the
     *                       rest of the view when changes in the grid, and therefore the game, are completed. gameController is an observer.
     */
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
                Image imgEmptyGrid = getImageFromResources("/view/images/empty.png");
                currentImageView.setImage(imgEmptyGrid);

                // Setting the action
                currentImageView.setOnMouseClicked(cellClicked(j));

                // Adding to the gridPane
                grid.add(currentImageView,j,i);
            }
        }

        return grid;

    }

    private EventHandler<MouseEvent> cellClicked(int columnIndex){
        return mouseEvent -> {
            if(!winner) {
                if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                    int playingPlayer = gridController.getPlayer();
                    int chipPlayedInRow = gridController.cellClicked(columnIndex);
                    if (chipPlayedInRow > -1) {

                        Image imgFullGrid;
                        if (playingPlayer == 1){
                            imgFullGrid = getImageFromResources("/view/images/full1.png");
                        } else {
                            imgFullGrid = getImageFromResources("/view/images/full2.png");
                        }
                        imageViewGrid[chipPlayedInRow][columnIndex].setImage(imgFullGrid);

                        //Change game labels if needed

                        //Winner Label
                        if (gridController.isThereAWinner()) {
                            gameController.changeWinnerLabel(playingPlayer);
                            winner = true;
                        } else {
                            //Turn label
                            gridController.changePlayer();
                            gameController.changeTurnDisplay(gridController.getPlayer());
                        }


                    }

                }
            }
        };
    }

    /**
     * Get the current GridPane object assigned to the attribute variable grid.
     * @return a GridPane with the row and column dimensions of the current connect4 game each pane contains images that
     * represent each cell of the board in their corresponding state, this is, empty or with a chip of player 1 or 2.
     */
    public GridPane getGrid() { return grid;}

    private Image getImageFromResources(String path){
        try {
            InputStream imageInputStream = Connect4Grid.class.getResourceAsStream(path);
            if(imageInputStream == null){
                throw new IOException();
            }
            return new Image(new ByteArrayInputStream(IOUtils.toByteArray(imageInputStream)));
        } catch (IOException e) {
            System.out.println("Unable to retrieve empty grid image");
            e.printStackTrace();
            return null;
        }
    }



}
