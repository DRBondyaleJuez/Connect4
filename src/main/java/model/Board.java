package model;

/**
 * Provides the objects that represent board of cells.
 * <p>
 *     The board is composed by a matrix or array of arrays of cell objects and monitors the player's turn, this is the player which is playing.
 * </p>
 * @author Daniel R Bondyale Juez
 * @version 1.0
 */
public class Board {

    private Cell[][] cellMatrix;
    private int player;


    /**
     * This is the constructor.
     * @param nRow number of rows in the board.
     * @param nColumn number of columns in the board.
     */
    public Board(int nRow,int nColumn) {
        cellMatrix = new Cell[nRow][nColumn];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColumn; j++) {

                cellMatrix[i][j] = new Cell(i,j);
            }
        }
        player = 1;
    }

    /**
     * Get a particular cell object in a particular position
     * <p> The cell object is selected based on row and column position provided which retrieves the object from the matrix or array of arrays. </p>
     * @param row the row position this is row index from 0 to the number of rows minus 1.
     * @param column the column position this is column index from 0 to the number of columns minus 1.
     * @return the cell object in that position.
     */
    public Cell getCell(int row, int column){
        return cellMatrix[row][column];
    }

    public Cell[][] getCellMatrix() {
        return cellMatrix;
    }

    /**
 * Simulate the placement of a chip in a particular cell
 * <p> Playing a chip is simulated by changing the value in particular cell object from 0 to the playing player number 1 or 2.
 * Given a particular position in the row this method finds the lowest empty position in the column to place the chip, this means, change the value of the cell.
 * It prioritizes placing the chip as close as possible to the bottom of the board. The bottom being the highest index in the column. </p>
 * @param rowPosition this is the position or index in a particular row from 0 to the number of columns minus 1.
 * @return an integer that corresponds to the column position where the chip has been placed. If the column is full it returns -1.
 */
    public int playChip(int rowPosition){
        int columnPosition = findColumnPositionEmptyCell(rowPosition);
        if(columnPosition > -1){
            cellMatrix[rowPosition][columnPosition].setValue(player);
        }
        return columnPosition;
    }

    private int findColumnPositionEmptyCell(int rowPosition){
        for (int i = cellMatrix[0].length - 1; i > -1; i--) {
            if(cellMatrix[rowPosition][i].getValue() == 0) return i;
        }
        return -1;
    }


    /**
     * Get the current value of the player attribute of the board object
     * @return an integer that corresponds to the current player either 1 or 2
     */
    public int getPlayer(){
        return player;
    }

    /**
     * Change the player attribute from 1 to 2 or from 2 to 1
     */
    public void changePlayer(){
        if(player == 1) {
            player = 2;
        }else {
            player = 1;
        }
    }
}
