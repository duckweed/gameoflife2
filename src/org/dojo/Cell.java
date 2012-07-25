package org.dojo;

/**
 * Copyright AdScale GmbH, Germany, 2007
 */
public class Cell {

    public enum CellState {
        ALIVE,
        DEAD;
    }

    public int neighboursAlive;

    public CellState state = CellState.DEAD;


    public int neighboursCount() {
        return 8;
    }


    public CellState nextState() {

        if (this.state ==CellState.ALIVE) {
            if (neighboursAlive==2 || neighboursAlive == 3)
            {
                return CellState.ALIVE;
            }
            else
            {
                return CellState.DEAD;
            }

        }
        else {
            if (neighboursAlive == 3) {
                return CellState.ALIVE;
            }
            else {
                return CellState.DEAD;
            }
        }

        //return CellState.DEAD;
    }
}
