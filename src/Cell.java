/**
 * Copyright AdScale GmbH, Germany, 2007
 */
public class Cell {

    public enum CellState {
        ALIVE,
        DEAD;
    }

    public int neighboursAlive;

    public boolean isAlive;


    public int neighboursCount() {
        return 8;
    }


    public CellState nextState() {

        //if (this.isAlive) {

            switch (neighboursAlive) {
                case 1:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    return CellState.DEAD;

                default:
                    return CellState.ALIVE;  //To change body of created methods use File | Settings | File Templates.
            }

        //}

        //return CellState.DEAD;
    }
}
