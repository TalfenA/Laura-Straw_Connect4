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
        Game testingGame = new Game(3,3,3);

        //Player attempting to over-fill a column
        assertTrue(testingGame.makeMove(1, Player.PLAYER1));
        assertTrue(testingGame.makeMove(1,Player.PLAYER1));
        assertTrue(testingGame.makeMove(1,Player.PLAYER1));
        assertFalse(testingGame.makeMove(1,Player.PLAYER1));


    }

    /**
     * Test expected outcomes from a user trying to place a token in a column which does not exist
     */
    @Test
    void testNoColumn(){
        //Given test method
        Game testingGame = new Game(3,3,3);

        //Player attempting to use a column that doesn't exist
        assertFalse(testingGame.makeMove(4,Player.PLAYER1));
    }
}