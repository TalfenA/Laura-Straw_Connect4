package org.Connect_4_Game;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * The main class for the connect-4 game, where the program is structured and run
 * @author Laura Straw
 * @version 0.1 - 24/04/26
 */
public class Main {
    //Set up the logger for the main class
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    /**
     * The main method of the program, where the input scanner is created and setup initialised
     * @param args
     */
    public static void main(String[] args) {
        logger.info("Application start");

        logger.info("Create scanner for input");
        Scanner scan = new Scanner(System.in);

        //Set up the game
        setupGame(scan);
    }

    /**
     * The setup class to begin a game of connect 4, allowing change to the win condition and board size before creating the game
     * @param scan the scanner for input, passed through from the main method
     */
    private static void setupGame(Scanner scan){
        logger.info("Setting up game");

        //Create variables to use in setup, containing default game values
        int[] boardSize = {5,6};
        int winCondition = 4;


        //Allow the user to customise the board size
        System.out.println("\t Change the size of the board? (Default: " + boardSize[0] + " x " + boardSize[1] + ")");
        System.out.print("\t \t Y/N: ");
        try{
            if(scan.next().equals("Y")){
                System.out.print("\t \t Width: ");
                boardSize[0] = Integer.parseInt(scan.next());
                System.out.print("\t \t Height: ");
                boardSize[1] = Integer.parseInt(scan.next());
            }
        }catch(Exception e){
            logger.info("Setup failed due to incorrect user input");
            System.err.println("Setup failed, please make sure your input is correct (Whole numbers only)");
            setupGame(scan);
        }


        //Allow the user to customise the win condition
        System.out.println("\t Change the win condition? (Default: " + winCondition + ")");
        System.out.print("\t \t Y/N: ");
        try{
            if(scan.next().equals("Y")){
                System.out.print("\t \t Connect: ");
                winCondition = Integer.parseInt(scan.next());
            }
        }catch(Exception e){
            logger.info("Setup failed due to incorrect user input");
            System.err.println("Setup failed, please make sure your input is correct (Whole numbers only)");
            setupGame(scan);
        }


        //Create two player objects
        Player player1 = new Player("Player 1", PlayerColours.Colours.RED);
        Player player2 = new Player("Player 2", PlayerColours.Colours.YELLOW);


        //Initialise the 'Game' class with the players, dimensions, and win condition
        Game thisGame = new Game(player1, player2, winCondition, boardSize);


        //Begin the game using the newly created 'thisGame' object
        playGame(thisGame);
    }


    /**
     * A method to host the main gameplay of Connect 4
     * @param currentGame the game created in setup to use for this play
     */
    private static void playGame(Game currentGame){
        logger.info("Game started");

    }


}