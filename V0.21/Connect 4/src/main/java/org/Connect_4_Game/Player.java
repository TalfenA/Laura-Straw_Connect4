package org.Connect_4_Game;

/**
 * A class to hold basic player data, the name and associated colour.
 * @author Laura_Straw
 * @version 0.1 - 24/04/26
 */
public class Player {
    private String name;
    private PlayerColours.Colours colour;

    /**
     * Constructor for the 'org.Connect_4_Game.Player' class
     * @param name the name of the player, i.e. "org.Connect_4_Game.Player 1"
     * @param colour the enumerated colour associated with the player, i.e. "RED"
     */
    public Player(String name, PlayerColours.Colours colour){
        this.name = name;
        this.colour = colour;
    }

    /**
     * Get method to return the player's name
     * @return the player's name
     */
    public String getName(){
        return name;
    }

    /**
     * Get method to return the colour of the player
     * @return the ansii colour code of the player
     */
    public String getColour(){
        return colour.colourCode();
    }
}