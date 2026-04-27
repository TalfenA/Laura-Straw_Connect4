package org.example;

import com.sun.jdi.event.ExceptionEvent;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * A class to hold the main aspects of the game, including the players, board, and win condition.
 * @author Laura Straw
 * @version 0.3 - 27/04/26
 */
public class Game {
    //Logger for debugging + tracing
    private static Logger logger = Logger.getLogger(Main.class.getName());

    //The game board for the current game
    public Board gameBoard;
    //The win condition for this particular game
    private int winCondition;
    private Player currentPlayer = Player.P1;

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

        //Round management to identify a stalemate
        int round = 1;
        int maxRounds = gameBoard.getHeight() * gameBoard.getWidth();
        boolean gameRunning = true;
        int moveToMake = 0;

        //Enter into a game loop that only ends when a winner (or tie) is found
        while(gameRunning){
            //print the board to the user
            gameBoard.printBoard();

            //Inform the user what round it is and who is next to play
            System.out.println("Round " + round + ", Next up: " + currentPlayer);

            try {
                //Ask the user where they want to move to
                System.out.print("Choose column number -> ");
                moveToMake = getNextInteger();

                //Check the move doesn't exceed boundaries
                if (moveToMake < 1 || moveToMake > gameBoard.getWidth()) {
                    logger.info("Player gave a column number that does not exist");
                    throw new IllegalArgumentException("Column does not exist");
                }

                makeMove(moveToMake, currentPlayer);

            }catch(Exception e) {
                System.out.println("Please make sure you enter a valid column, try again!");
                logger.info("User input incorrect column, loop restarting with no player change");
            }

            try{
                //Check for winning or tie conditions and break to announce winner if true
                round++;

                //Only test fully for a win if there have been enough tokens placed to allow a win
                //Check the win with x as the column chosen and y as the new height
                if(round > winCondition && checkWin(moveToMake, gameBoard.getColumn(moveToMake).size())){
                    logger.info("Game ended due to player win");
                    gameRunning = false;
                    win();
                    break;
                }
                //Check for stalemate
                if(round > maxRounds){
                    logger.info("Game ended due to stalemate");
                    gameRunning = false;
                    stalemate();
                    break;
                }

                //Otherwise, change player
                changePlayer();

                //Create a visual break between rounds
                System.out.println("~~~~~~~~~~~~~~~~~~~~");

                //Loop around for another round!
            }catch(Exception e){
                logger.info("Error while checking for win conditions, debugging required");
                System.out.println("Sorry, an error occurred while checking who won, try starting again");
                break;
            }
        }

    }

    /**
     * A method to make a move on the connect 4 board
     * @param column which column the player would like to move into
     * @param player which player is making the move
     * @return true if the player successfully moves, false if an error is encountered.
     */
    public void makeMove(int column, Player player) {
        //Normalise column choice for 0-indexed list
        column = column - 1;
        try {
            //Check the column they want isn't full before progressing
            if (!gameBoard.isColumnFull(column)) {
                //Get the column that the player wants to move into + add token
                ArrayList<Player> toMoveInto = gameBoard.getColumn(column);
                toMoveInto.add(player);
            }
        }catch(Exception e){
            logger.info("Error while making the player's move");
        }
    }

    /**
     * A method to check for a win after a player has put a piece down
     * @return true if the player has won, false otherwise
     */
    public boolean checkWin(int x, int y){
        try {
            //Check for a win of the current player
            logger.info("Checking for a win with values X: " + x + " Y: " + y);
            //Check for a vertical downwards win
            gameBoard.winningLine(x, y, -1, 0, currentPlayer, winCondition);



            //If no win has happened
            return false;
        }catch(Exception e){
            logger.info("Error while checking for a win");
            return false;
        }
    }

    /**
     * A method to change the currently active player
     */
    private void changePlayer(){
        try {
            if (currentPlayer == Player.P1)
                currentPlayer = Player.P2;
            else
                currentPlayer = Player.P1;
        }catch(Exception e){
            logger.info("Error while changing player");
        }
    }

    /**
     * A method to visually announce a stalemate to the users
     */
    private void stalemate(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println("GAME OVER");
        System.out.println("No winner! Better luck next time");
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * A method to visually announce a win and who caused it to the users
     */
    private void win(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println(currentPlayer + " WINS!!");
        System.out.println("Well done! Come back for a rematch soon");
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
    }


    /**
     * A method to read the next user given integer
     * @return the next integer the user gives
     */
    private int getNextInteger(){
        try {
            Scanner scan = new Scanner(System.in);
            return Integer.parseInt(scan.next());
        }catch(Exception e) {
            logger.info("Error while reading an integer from the user");
            return -1;
        }
    }

    /**
     * A method to read the next user given string
     * @return the next string the user gives
     */
    private String getNextString(){
        try {
            Scanner scan = new Scanner(System.in);
            return scan.next();
        }catch(Exception e){
            logger.info("Error while reading a string from the user");
            return null;
        }
    }
}
