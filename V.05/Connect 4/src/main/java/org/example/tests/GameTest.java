package org.example.tests;

import org.example.Game;
import org.example.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    /**
     * Test expected outcomes from a user trying to place a token in a column which is already full
     */
    @Test
    void testOverflowMove() {
        //Given test method
        Game testingGame = new Game(3, 3, 3);

        //Player attempting to over-fill a column
        assertTrue(testingGame.makeMove(1, Player.P1));
        assertTrue(testingGame.makeMove(1, Player.P1));
        assertTrue(testingGame.makeMove(1, Player.P1));
        assertFalse(testingGame.makeMove(1, Player.P1));


    }

    /**
     * Test expected outcomes from a user trying to place a token in a column which does not exist
     */
    @Test
    void testNoColumn() {
        //Given test method
        Game testingGame = new Game(3, 3, 3);

        //Player attempting to use a column that doesn't exist
        assertFalse(testingGame.makeMove(4, Player.P1));
    }

    @Test
    void testGettingLines() {
        //Given test method
        Game testingGame = new Game(3, 3, 3);

        //Put tokens in columns 1 (twice), and 2
        testingGame.makeMove(1, Player.P1);
        testingGame.makeMove(1, Player.P1);
        testingGame.makeMove(2, Player.P1);

        //Get the top row (3) - Empty, no error should be thrown
        testingGame.gameBoard.getRow(3);
        //Get the second row (2) - one token, no error should be thrown
        testingGame.gameBoard.getRow(3);
        //Get the bottom row (1) - two tokens, no error should be thrown
        testingGame.gameBoard.getRow(3);
        //Get a row that doesn't exist (5) - error should be handled neatly and not cause exception
        testingGame.gameBoard.getRow(5);


    }

    @Test
    void testPrintingBoard() {
        //Given test method
        Game testingGame = new Game(3, 3, 3);

        //Empty board
        testingGame.gameBoard.printBoard();

        System.out.println("=======================NEW TEST");

        //Normal rows
        testingGame.makeMove(1, Player.P1);
        testingGame.makeMove(2, Player.P2);
        testingGame.makeMove(2, Player.P1);
        testingGame.gameBoard.printBoard();

        System.out.println("=======================NEW TEST");

        //Completely fill board
        testingGame.makeMove(1, Player.P2);
        testingGame.makeMove(1, Player.P1);
        testingGame.makeMove(2, Player.P2);
        testingGame.makeMove(3, Player.P1);
        testingGame.makeMove(3, Player.P2);
        testingGame.makeMove(3, Player.P1);
        testingGame.gameBoard.printBoard();

        System.out.println("=======================NEW TEST");

    }
}