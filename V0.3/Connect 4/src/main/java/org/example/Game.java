package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * A class to hold the main aspects of the game, including the players, board, and win condition.
 * @author Laura Straw
 * @version 0.2 - 26/04/26
 */
public class Game {
    //Logger for debugging + tracing
    private static Logger logger = Logger.getLogger(Main.class.getName());

    //The game board for the current game
    private Board gameBoard;
    //The win condition for this particular game
    private int winCondition;
    private int currentPlayer = 1;

    /**
     * Constructor for the Game class, facilitating user-led setup of the game.
     */
    public Game(){
        setupGame();
    }

    /**
     * A constructor for the Game method for manual initialisation, used during testing
     * @param width the player 1 object
     * @param height the player 2 object
     * @param winCondition the number of tokens in a row to class as a win
     */
    public Game(int width, int height, int winCondition){
        gameBoard = new Board(width, height);
        this.winCondition = winCondition;
    }

    /**
     * The setup method to begin a game of connect 4, getting the user to customise the win condition and board size before creating the game
     */
    private void setupGame(){
        int[] boardSize = {0,0};

        try{
            //Allow the user to customise the board size
            System.out.println("//// Choose the board size (Standard: 7x6) \\\\\\\\");
            System.out.print("\t Width: ");
            boardSize[0] = getNextInteger();
            System.out.print("\t Height: ");
            boardSize[1] = getNextInteger();

            //Create game board of specified size
            gameBoard = new Board(boardSize[0], boardSize[1]);

            //Allow the user to customise the win condition
            System.out.println("//// Choose the win condition (Standard: 4) \\\\\\\\");
            System.out.print("\t \t Connect: ");
            winCondition = getNextInteger();

            logger.info("Game has been set up with a " + boardSize[0] + " by " + boardSize[1] + " board and Connect " + winCondition + " win condition");

        }catch(Exception e){
            logger.info("Setup failed due to incorrect user input");
            System.err.println("Setup failed, please make sure your input is correct (Whole numbers only)");
            setupGame();
        }
    }

    /**
     * A method to hold connect 4 gameplay
     */
    public void play(){
        logger.info("Gameplay beginning");



    }

    /**
     * A method to make a move on the connect 4 board
     * @param column which column the player would like to move into
     * @param player which player is making the move
     * @return true if the player successfully moves, false if an error is encountered.
     */
    public boolean makeMove(int column, Player player) {
        try {
            //Check the column they want isn't full before progressing
            if (!gameBoard.isColumnFull(column)) {
                //Get the column that the player wants to move into + add token
                ArrayList<Player> toMoveInto = gameBoard.getColumn(column);
                toMoveInto.add(player);
                return true;
            } else {
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }

    /**
     * A method to read the next user given integer
     * @return the next integer the user gives
     */
    private int getNextInteger(){
        Scanner scan = new Scanner(System.in);
        return Integer.parseInt(scan.next());
    }

    /**
     * A method to read the next user given string
     * @return the next string the user gives
     */
    private String getNextString(){
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}
