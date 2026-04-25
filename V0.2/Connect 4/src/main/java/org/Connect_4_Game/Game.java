package org.Connect_4_Game;

/**
 * A class to hold the main aspects of the game, including the players, board, and win condition.
 * @author Laura Straw
 * @version 0.1 - 24/04/26
 */
public class Game {
    private Player[] players = new Player[2];
    private int winCondition;

    private Board gameBoard;

    /**
     * A constructor for the 'org.Connect_4_Game.Game' class, called from the internal 'SetupGame' method
     * @param player1 the player 1 object
     * @param player2 the player 2 object
     * @param winCondition the number of tokens in a row to class as a win
     * @param dimensions the x and y values to use as board dimensions
     */
    public Game(Player player1, Player player2, int winCondition, int[] dimensions){
        this.players[0] = player1;
        this.players[1] = player2;

        this.winCondition = winCondition;

        this.gameBoard = new Board(dimensions[0], dimensions[1]);

    }

    /**
     * Get method to return the required number of tokens in a row to cause a win
     * @return the win condition
     */
    public int getWinCondition(){
        return winCondition;
    }
}