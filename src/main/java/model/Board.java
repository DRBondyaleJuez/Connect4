package model;

public class Board {

    private Cell[][] cellMatrix;
    private int player;


    public Board(int nRow,int nColumn) {
        cellMatrix = new Cell[nRow][nColumn];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColumn; j++) {

                cellMatrix[i][j] = new Cell(i,j);
            }
        }
        player = 1;
    }

    public Cell getCell(int row, int column){
        return cellMatrix[row][column];
    }

    public int playChip(int rowPosition){
        int columnPosition = findColumnPositionEmptyCell(rowPosition);
        if(columnPosition > -1){
            cellMatrix[rowPosition][columnPosition].setValue(player);
        }
        return columnPosition;
    }

    public int findColumnPositionEmptyCell(int rowPosition){
        for (int i = cellMatrix[0].length - 1; i > -1; i--) {
            if(cellMatrix[rowPosition][i].getValue() == 0) return i;
        }
        return -1;
    }

    public boolean hasThisPlayerWon(){
        Connect4Verifier verifier = new Connect4Verifier(cellMatrix, player);
        return verifier.isThereAWinner();
    }

    public int getPlayer(){
        return player;
    }

    public void changePlayer(){
        if(player == 1) {
            player = 2;
        }else {
            player = 1;
        }
    }
}
