package controller;

import model.Cell;

/**
 * Provides the objects that are used to verify if the game has a winner.
 * <p>
 *     The object is constructed with the matrix of integers corresponding to the matrix of cell values and player that
 *     will be used to verify if it is the winner
 * </p>
 * @author Daniel R Bondyale Juez
 * @version 1.0
 */
public class Connect4Verifier {

    private int[][] boardStateMatrix;
    private int player;

    /**
     * This is the constructor.
     * @param board matrix of cells used to build the matrix of integers
     * @param player the player whose victory will be check, either 1 or 2.
     */
    public Connect4Verifier(Cell[][] board, int player) {

        int rowLength = board.length;
        int columnLength = board[0].length;

        boardStateMatrix = new int[rowLength][columnLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++){

                boardStateMatrix[i][j] = board[i][j].getValue();
            }
        }

        this.player = player;
    }

    /**
     * Checks if the player assigned to the attribute player has won the game
     * <p>
     *     Goes through the integer matrix from bottom to the top, this is, starting from the row of the highest column
     * position or index, the number of rows -1. When an integer with the value of the player is found the surrounding
     * matrix position to the right and above are checked to see if they match until 4 continues are found. The matrix is
     * covered until a row full of zeros is found. or the top row is checked without finding matches.
     * </p>
     * @return a boolean. False is a row full of zeros is found without any previous matches or all the rows have been
     * verified without 4 connected. True if 4 connected matrix positions are found, this is, 4 contiguous matrix positions
     * with the player number.
     */
    public boolean isThereAWinner(){
        //Careful i starts being the columnPosition and j is the rowPosition
        for (int i = boardStateMatrix[0].length - 1; i > -1; i--) {
            if(rowOfZeros(i)) return false;
            for (int j = 0; j < boardStateMatrix.length; j++) {
                if(boardStateMatrix[j][i] == player){
                    if(testAllDirections(j,i)) return true;
                }
            }
        }
        return false;
    }

    private boolean testAllDirections(int rowPosition, int colPosition){

        int connexionNumber = 4;

        if(horizontalScan(rowPosition,colPosition,connexionNumber)) return true;
        if(verticalScan(rowPosition,colPosition,connexionNumber)) return true;
        if(diagonalTopLeftScan(rowPosition,colPosition,connexionNumber)) return true;
        if (diagonalTopRightScan(rowPosition, colPosition, connexionNumber)) return true;

        return false;
    }

    // This method would verify if there are 4 in a row in the vertical direction
    private boolean horizontalScan(int rowPosition, int colPosition, int counter){

        if(counter == 1) return true;

        if(colPosition == 0) return false;

        if(boardStateMatrix[rowPosition][colPosition-1] != player){
            return false;
        } else {
            return horizontalScan(rowPosition,colPosition-1,counter-1);
        }
    }

    // This method would verify if there are 4 in a column in the horizontal direction
    private boolean verticalScan(int rowPosition, int colPosition, int counter){

        if(counter == 1){return true;}

        if(rowPosition >= boardStateMatrix.length-1){return false;}

        if(boardStateMatrix[rowPosition+1][colPosition] != player){
            return false;
        } else {
            return verticalScan(rowPosition+1,colPosition,counter-1);
        }
    }

    // This method would verify if there are 4 in a column in the diagonal \ direction
    private boolean diagonalTopLeftScan(int row, int col,int counter){

        if(counter == 1){return true;}

        if(col == 0 || row == 0){return false;}

        if(boardStateMatrix[row-1][col-1] != player){
            return false;
        } else {
            return diagonalTopLeftScan(row-1,col-1,counter-1);
        }
    }

    // This method would verify if there are 4 in a column in the diagonal / direction
    private boolean diagonalTopRightScan(int row, int col,int counter){

        if(counter == 1){return true;}

        if(col >= boardStateMatrix[0].length-1 || row == 0){return false;}

        if(boardStateMatrix[row-1][col+1] != player){
            return false;
        } else {
            return diagonalTopRightScan(row-1,col+1,counter-1);
        }
    }

    //This method is to verify if it has reached a row of 0
    private boolean rowOfZeros(int columnPosition){
        for (int i = 0; i < boardStateMatrix.length-1; i++) {
            if(boardStateMatrix[i][columnPosition] != 0){return false;}
        }
        return true;
    }

}
