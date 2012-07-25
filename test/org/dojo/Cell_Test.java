package org.dojo;

import static org.dojo.Cell.CellState;
import static org.dojo.Cell.CellState.ALIVE;
import static org.dojo.Cell.CellState.DEAD;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

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
        assertThat(cell.state, is(DEAD));
    }


    @Test
    public void cellWithThreeLiveNeighboursBecomesAlive() throws Exception {
        Cell cell = new Cell();
        cell.neighboursAlive = 3;

        assertThat(cell.nextState(), is(ALIVE));
    }


    @Test
    public void cellWithOneLiveNeighboursBecomesDead() throws Exception {
        Cell cell = new Cell();
        cell.neighboursAlive = 1;

        assertThat(cell.nextState(), is(DEAD));
    }


    @Test
    public void liveCellWithFewerThanTwoLiveNeighboursDies() throws Exception {
        assertCellWithNeighborsNextStateEquals(ALIVE, 0, DEAD);
        assertCellWithNeighborsNextStateEquals(ALIVE, 1, DEAD);
    }


    @Test
    public void givenLiveCellWith2or3liveNeighbours() {
        assertCellWithNeighborsNextStateEquals(ALIVE, 2, ALIVE);
        assertCellWithNeighborsNextStateEquals(ALIVE, 3, ALIVE);
    }


    @Test
    public void givenLiveCellWithMoreThan3neighboursDies() throws Exception {
        assertCellWithNeighborsNextStateEquals(ALIVE, 4, DEAD);
        assertCellWithNeighborsNextStateEquals(ALIVE, 5, DEAD);
        assertCellWithNeighborsNextStateEquals(ALIVE, 6, DEAD);
        assertCellWithNeighborsNextStateEquals(ALIVE, 7, DEAD);
        assertCellWithNeighborsNextStateEquals(ALIVE, 8, DEAD);
    }


    //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
    @Test
    public void givenADeadCellWithExactlyThreeNeighboursComesToLife() {
        assertCellWithNeighborsNextStateEquals(DEAD, 3, ALIVE);
    }


    @Test
    public void givenADeadCellThatDoesntHave3LiveNeighbours_staysDead() throws Exception {
        assertCellWithNeighborsNextStateEquals(DEAD, 0, DEAD);
        assertCellWithNeighborsNextStateEquals(DEAD, 1, DEAD);
        assertCellWithNeighborsNextStateEquals(DEAD, 2, DEAD);
        assertCellWithNeighborsNextStateEquals(DEAD, 4, DEAD);
        assertCellWithNeighborsNextStateEquals(DEAD, 5, DEAD);
        assertCellWithNeighborsNextStateEquals(DEAD, 6, DEAD);
        assertCellWithNeighborsNextStateEquals(DEAD, 7, DEAD);
        assertCellWithNeighborsNextStateEquals(DEAD, 8, DEAD);
    }


    private void assertCellWithNeighborsNextStateEquals(CellState currentState, int liveNeighbours, CellState expectedState) {
        Cell cell = new Cell();
        cell.state = currentState;
        cell.neighboursAlive = liveNeighbours;

        assertThat(cell.nextState(), is(expectedState));
    }

}
