package controller;

import model.Board;

/**
 * Provides the object in charged of interactions between the Connect4Grid in the view and the grid model board object.
 * <p>
 *     This controller allows the view to recall information needed about the state of the board and game. It also
 *     commands actions to be taken by the board model to reflect the interaction with the view.
 * </p>
 * @author Daniel R Bondyale Juez
 * @version 1.0
 */
public class Connect4GridController {

    private final Board currentBoard;

    /**
     * This is the constructor. The board dimensions are assigned during its construction as an attirbute of this controller.
     */
    public Connect4GridController() {
        //Creating new board with 7 rows and 6 columns
        currentBoard = new Board(7,6);
    }

    /**
     * Call the board attribute to play a chip at a certain column of the cell matrix.
     * <p>
     *     Playing a certain chip at a certain column implies changing the value of a particular cell corresponding to the lowest
     *     available cell of that column that was clicked in the grid.
     * </p>
     * @param rowPosition this is the position or index in a particular row from 0 to the number of columns minus 1.
     * @return an integer that corresponds to the column position where the chip has been placed. If the column is full it returns -1.
     */
    public int cellClicked(int rowPosition){
       return currentBoard.playChip(rowPosition);
    }

    /**
     * Get the current value of the player attribute of the board attribute
     * @return an integer that corresponds to the current player either 1 or 2
     */
    public int getPlayer(){
        return currentBoard.getPlayer();
    }


    /**
     * Verify whether the current player has won the game, this is, has connected 4
     * <p> Build a Connect4Verifier object and return the result of calling the method isThereAWinner. </p>
     * @return a boolean. True if the current player has won or false if the current player is not the winner
     */
    public boolean isThereAWinner(){
        Connect4Verifier verifier = new Connect4Verifier(currentBoard.getCellMatrix(), currentBoard.getPlayer());
        return verifier.isThereAWinner();
    }

    /**
     * Change the player attribute of the board attribute from 1 to 2 or from 2 to 1 by calling the changePlayer method.
     */
    public void changePlayer(){
        currentBoard.changePlayer();
    }


}
