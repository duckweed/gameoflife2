package org.dojo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.dojo.Cell;
import org.junit.Test;

public class Cell_Test {

    @Test
    public void givenaCellOurNeighbourCellCountIsEight() throws Exception {
        //Given
        Cell cell = new Cell();
        //when

        //then
        assertEquals(8, cell.neighboursCount());
    }


    @Test
    public void givenaNewCellAllNeighbourAreDead() throws Exception {
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
        assertThat(cell.isAlive, is(Cell.CellState.DEAD));
    }


    @Test
    public void cellWithThreeLiveNeighboursBecomesAlive() throws Exception {
        Cell cell = new Cell();
        cell.neighboursAlive = 3;

        assertThat(cell.nextState(), is(Cell.CellState.ALIVE));
    }


    @Test
    public void cellWithOneLiveNeighboursBecomesDead() throws Exception {
        Cell cell = new Cell();
        cell.neighboursAlive = 1;

        assertThat(cell.nextState(), is(Cell.CellState.DEAD));
    }


    @Test
    public void liveCellWithFewerThanTwoLiveNeighboursDies() throws Exception {
        assertCellState(Cell.CellState.ALIVE, 0, Cell.CellState.DEAD);
        assertCellState(Cell.CellState.ALIVE, 1, Cell.CellState.DEAD);
    }


    @Test
    public void givenLiveCellWith2or3liveNeighbours() {
        assertCellState(Cell.CellState.ALIVE, 2, Cell.CellState.ALIVE);
        assertCellState(Cell.CellState.ALIVE, 3, Cell.CellState.ALIVE);
    }


    @Test
    public void givenLiveCellWithMoreThan3neighboursDies() throws Exception {
        assertCellState(Cell.CellState.ALIVE, 4, Cell.CellState.DEAD);
        assertCellState(Cell.CellState.ALIVE, 5, Cell.CellState.DEAD);
        assertCellState(Cell.CellState.ALIVE, 6, Cell.CellState.DEAD);
        assertCellState(Cell.CellState.ALIVE, 7, Cell.CellState.DEAD);
        assertCellState(Cell.CellState.ALIVE, 8, Cell.CellState.DEAD);
    }


    //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
    @Test
    public void givenADeadCellWithExactlyThreeNeighboursComesToLife() {
        assertCellState(Cell.CellState.DEAD, 3, Cell.CellState.ALIVE);
    }


    @Test
    public void givenADeadCellThatDoesntHave3LiveNeighbours_staysDead() throws Exception {
        assertCellState(Cell.CellState.DEAD, 0, Cell.CellState.DEAD);
        assertCellState(Cell.CellState.DEAD, 1, Cell.CellState.DEAD);
        assertCellState(Cell.CellState.DEAD, 2, Cell.CellState.DEAD);
        assertCellState(Cell.CellState.DEAD, 4, Cell.CellState.DEAD);
        assertCellState(Cell.CellState.DEAD, 5, Cell.CellState.DEAD);
        assertCellState(Cell.CellState.DEAD, 6, Cell.CellState.DEAD);
        assertCellState(Cell.CellState.DEAD, 7, Cell.CellState.DEAD);
        assertCellState(Cell.CellState.DEAD, 8, Cell.CellState.DEAD);
    }


    private void assertCellState(Cell.CellState currentState, int liveNeighbours, Cell.CellState expectedState) {
        Cell cell = new Cell();
        cell.isAlive = currentState;
        cell.neighboursAlive = liveNeighbours;

        assertThat(cell.nextState(), is(expectedState));
    }

}
