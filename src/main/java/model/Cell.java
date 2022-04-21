package model;

public class Cell {

    private int row;
    private int column;
    private int value;

    // This is each of the square boxes of the connect 4 game where each player plays

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        value = 0;
    }

    public void setValue(int player){
        value = player;
    }

    public int getValue(){ return value;}


}
