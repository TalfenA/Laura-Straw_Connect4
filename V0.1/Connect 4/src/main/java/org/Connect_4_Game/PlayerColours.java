package org.Connect_4_Game;

/**
 * A class to hold enumerated colours and their associated ansii colour codes for easy retrieval during the player creation process
 * @author Laura_Straw
 * @version 0.1 - 24/04/26
 */
public class PlayerColours {
    /**
     * The enumeration holding english-language colours and their ansii equivalents for easy reference and implementation
     */
    public enum Colours {
        /**
         * The colour red, stored as enumerated plain english with an associated ansii code
         */
        RED("\\u001B[31m"),
        /**
         * The colour yellow, stored as enumerated plain english with an associated ansii code
         */
        YELLOW("\\u001B[33m");

        //Variable to hold the colour code
        private String colourCode;

        /**
         * Constructor allowing the enumerated colours to be given associated ansii codes
         * @param colourCode
         */
        Colours(String colourCode) {
            this.colourCode = colourCode;
        }

        /**
         * Get method to return the colour code of the given colour
         * @return a colour's ansii code
         */
        public String colourCode() {
            return this.colourCode;
        }
    }
}