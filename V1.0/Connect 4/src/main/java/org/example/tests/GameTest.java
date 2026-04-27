package org.example.tests;

import org.example.Game;
import org.example.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

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

    @Test
    void testWinConditions(){
        //Given test method
        Game testingGame = new Game(3,3,3);

        //Check false is returned when checking wins on an empty board
        assertFalse(testingGame.checkWin(2,2));

        //Check true is returned for a vertical line
        testVerticalWin();

        //Check true is returned for a horizontal line
        testHorizontalWin();

        //Check true is returned for a diagonal line
        testDiagonalWin();
    }

    @Test
    void testVerticalWin(){
        //Given test method
        Game verticalGame = new Game(3,3,3);

        verticalGame.makeMove(1, Player.P1);
        verticalGame.makeMove(1, Player.P1);
        verticalGame.makeMove(1, Player.P1);

        assertTrue(verticalGame.checkWin(1,3));
    }

    @Test
    void testHorizontalWin(){
        //Given test method
        Game horizontalGame = new Game(3,3,3);

        horizontalGame.makeMove(1, Player.P1);
        horizontalGame.makeMove(2, Player.P1);
        horizontalGame.makeMove(3, Player.P1);

        assertTrue(horizontalGame.checkWin(3,1));
    }

    @Test
    void testDiagonalWin(){
        //Given test method
        Game diagonalGame = new Game(3,3,3);

        diagonalGame.makeMove(1, Player.P1);
        diagonalGame.makeMove(2, Player.P2);
        diagonalGame.makeMove(2, Player.P1);
        diagonalGame.makeMove(3, Player.P2);
        diagonalGame.makeMove(3, Player.P2);
        diagonalGame.makeMove(3, Player.P1);

        assertTrue(diagonalGame.checkWin(3,3));
    }


}