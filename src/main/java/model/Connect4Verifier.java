package model;

public class Connect4Verifier {

    private int[][] boardStateMatrix;
    private int player;


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
