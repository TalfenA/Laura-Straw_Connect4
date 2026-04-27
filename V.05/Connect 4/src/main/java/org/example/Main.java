package org.example;

/**
 * The main class for the connect-4 game, where the program is initiated
 * @author Laura Straw
 * @version 0.3 - 26/04/26
 */
public class Main {
    public static void main(String[] args) {

        //Create a new game board that the user can customise
        Game newGame = new Game();

        //Begin gameplay within the newly made game object
        newGame.play();
    }
}