package org.dojo;

/**
 * Copyright AdScale GmbH, Germany, 2007
 */
public class GameOfLife {

    String gameState = "XXX";

    public String getState() {
        return gameState;  //To change body of created methods use File | Settings | File Templates.
    }


    public void iterate() {
        if (gameState.equals("XXX")){
            gameState =  "X\nX\nX";
        }
        else {
            gameState = "XXX";
        }
    }
}
