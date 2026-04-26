package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to set up and hold the game board, initialised via the 'org.Connect_4_Game.Game' class.
 * @author Laura Straw
 * @version 0.2 - 26/04/26
 */
public class Board{
    private ArrayList<ArrayList<Player>> width;
    private int height;

    /**
     * Constructor for the 'org.Connect_4_Game.Board' class, setting up the blank list of lists used for gameplay
     * @param width how many columns the player can drop tokens down
     * @param height how tall the columns are
     */
    public Board(int width, int height) {
        //Set height as an integer to check against
        this.height = height;
        //Set width as a list to store lists (columns) in
        this.width = new ArrayList<>();

        //Populate the width list with each empty column
        for (int widthCounter = 0; widthCounter < width; ++widthCounter) {
            this.width.add(new ArrayList<Player>());
        }
    }

    /**
     * A public method to get the maximum height of columns
     * @return max height of columns
     */
    public int getHeight(){

        return height;
    }

    /**
     * A public method to get a specific column of the board
     * @param index of the column to be returned
     * @return the column available at the given index
     */
    public ArrayList<Player> getColumn(int index){

        return width.get(index);
    }

    /**
     * A public method to return whether a column is already full or not
     * @param getAt the column to check for fullness
     * @return a boolean, where true=full
     */
    public boolean isColumnFull(int getAt){
        return (width.get(getAt).size() >= height);
    }


}