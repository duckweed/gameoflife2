import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Cell_Test {

    @Test
    public void givenaCellOurNeighbourCellCountIsEight() throws Exception{
        //Given
        Cell cell = new Cell();
        //when

        //then
        assertEquals(8, cell.neighboursCount());
    }

    @Test
    public void givenaNewCellAllNeighbourAreDead() throws Exception{
        //given
        Cell cell = new Cell();
        //when

        //then
        assertEquals(0, cell.neighboursAlive);

    }

    @Test
    public void givenaNewCell_CellIsDead() {
        // given
        Cell cell = new Cell();

        // when


        // then
        assertFalse(cell.isAlive);
    }
    
    @Test
    public void cellWithThreeLiveNeighboursBecomesAlive() throws Exception{
        Cell cell = new Cell();
        cell.neighboursAlive = 3;

        assertThat(cell.nextState(), is(Cell.CellState.ALIVE));
    }

    @Test
    public void cellWithOneLiveNeighboursBecomesDead() throws Exception{
        Cell cell = new Cell();
        cell.neighboursAlive = 1;

        assertThat(cell.nextState(), is(Cell.CellState.DEAD));
    }

    @Test
    public void liveCellWithFewerThanTwoLiveNeighboursDies()throws Exception{
        assertCellState(true, 1, Cell.CellState.DEAD);
    }

    @Test
    public void givenLiveCellWith2or3liveNeighbours(){
        assertCellState(true, 2, Cell.CellState.ALIVE);
        assertCellState(true, 3, Cell.CellState.ALIVE);
    }

    @Test
    public void givenLiveCellWithMoreThan3neighboursDies() throws Exception{
        assertCellState(true, 4, Cell.CellState.DEAD);
        assertCellState(true, 5, Cell.CellState.DEAD);
        assertCellState(true, 6, Cell.CellState.DEAD);
        assertCellState(true, 7, Cell.CellState.DEAD);
        assertCellState(true, 8, Cell.CellState.DEAD);
    }

    //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
    @Test
    public void givenADeadCellWithExactlyThreeNeighboursComesToLife()
    {
        assertCellState(false, 3, Cell.CellState.ALIVE);
    }



    private void assertCellState(boolean currentState, int liveNeighbours, Cell.CellState expectedState) {
        Cell cell = new Cell();
        cell.isAlive= currentState;
        cell.neighboursAlive= liveNeighbours;

        assertThat(cell.nextState(),is(expectedState));
    }

}
