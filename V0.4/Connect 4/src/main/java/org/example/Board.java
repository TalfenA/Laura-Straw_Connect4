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
     * A public method to get the total width of the game board
     * @return the width of the board
     */
    public int getWidth(){
        return width.size();
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

    /**
     * A method to get the token present at any given space on the board
     * @param x the x-index of the space to search (how far along the board)
     * @param y the y-index of the space to search (how far up the column)
     * @return either the player token present at the space or a null value
     */
    public Player getToken(int x, int y){
        List<Player> column = width.get(x);

        if(column.size() > y){
            return column.get(y);
        }
        else{
            return null;
        }
    }

    /**
     * A method to return a row of the board at a given index
     * @param index the y-index of the row to return
     * @return the left-to-right row of tokens at that index
     */
    public Player[] getRow(int index){
        //Create an empty array of the size of the board
        Player[] tokens = new Player[width.size()];

        //Get the token in each column at the required y level
        for(int i = 0; i < width.size(); i++){
            tokens[i] = getToken(i, index);
        }

        //Return the gathered row
        return tokens;
    }

    /**
     * A method to print out the game board onto the command line for the users
     */
    public void printBoard() {
        //Create empty array to store the current row in
        Player[] row = new Player[width.size()];

        //For the height of the board
        for (int i = height - 1; i > -1; i--) {
            //Get the current row, starting at the top of the board and working down
            row = getRow(i);
            //For the width of the board
            for (int x = 0; x < width.size(); x++) {
                //If the cell is empty, provide a blank "--" string to print
                if (row[x] == null) {
                    System.out.print("--\t");
                } else {
                    //Otherwise provide the player token to print
                    System.out.print(row[x] + "\t");
                }
            }
            //move down to the next row
            System.out.print("\n");
        }
    }

    /**
     * A method to check for a win after a player has put a piece down
     * @param player
     * @return
     */
    public boolean checkWin(Player player){
        //Check for a win of the current player

        //Check straight line
        //Check vertical line
        //Check diagonal behind
        //Check diagonal in front

        return false;
    }
}