package model;

/**
 * Provides the objects that represent cells that form the board.
 * <p>
 *     Each cell describes its own row and column based position and its state which corresponds to a value 0 if empty,
 *     1 if player 1 chip is present and 2 if player 2 chip is present.
 * </p>
 * @author Daniel R Bondyale Juez
 * @version 1.0
 */
public class Cell {

    private int row;
    private int column;
    private int value;

    // This is each of the square boxes of the connect 4 game where each player plays

    /**
     * This is the constructor.
     * @param row the row position in board from 0 to the height of the board minus one.
     * @param column the column position in the board from 0 to the width of the board minus one.
     */
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        value = 0;
    }

    /**
     * Set the value of the cell.
     * <p> This represents a certain player 1 or player 2 placing a chip</p>
     * @param player The player, either 1 or 2, that placed the chip in the cell.
     */
    public void setValue(int player){
        value = player;
    }

    /**
     * Get the level of expertise of this person.
     * <p> This is, 0 if the cell is empty and either 1 or 2 based on the player
     * that played a chip in this cell. </p>
     * @return the value of the cell, this is the player number 1 or 2 or 0 if empty.
     */
    public int getValue(){ return value;}


}
