package controller;

import model.Board;

public class Connect4GridController {

    private Board currentBoard;

    public Connect4GridController() {
        //Creating new board with 7 rows and 6 columns
        currentBoard = new Board(7,6);
    }

    /*
    cellClicked returns the position of the row of the empty cell changed or -1 if no empty cell available
     */
    public int cellClicked(int rowPosition){
       return currentBoard.playChip(rowPosition);
    }

    public int getPlayer(){
        return currentBoard.getPlayer();
    }

    public boolean isThereAWinner(){
        return currentBoard.hasThisPlayerWon();
    }

    public void changePlayer(){
        currentBoard.changePlayer();
    }


}
