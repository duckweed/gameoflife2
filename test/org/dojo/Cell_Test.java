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
        assertCellWithNeighborsDies(ALIVE, 0);
        assertCellWithNeighborsDies(ALIVE, 1);
    }


    @Test
    public void givenLiveCellWith2or3liveNeighbours() {
        assertCellWithNeighborsLives(ALIVE, 2);
        assertCellWithNeighborsLives(ALIVE, 3);
    }


    @Test
    public void givenLiveCellWithMoreThan3neighboursDies() throws Exception {
        assertCellWithNeighborsDies(ALIVE, 4);
        assertCellWithNeighborsDies(ALIVE, 5);
        assertCellWithNeighborsDies(ALIVE, 6);
        assertCellWithNeighborsDies(ALIVE, 7);
        assertCellWithNeighborsDies(ALIVE, 8);
    }


    //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
    @Test
    public void givenADeadCellWithExactlyThreeNeighboursComesToLife() {
        assertCellWithNeighborsLives(DEAD, 3);
    }


    @Test
    public void givenADeadCellThatDoesntHave3LiveNeighbours_staysDead() throws Exception {
        assertCellWithNeighborsDies(DEAD, 0);
        assertCellWithNeighborsDies(DEAD, 1);
        assertCellWithNeighborsDies(DEAD, 2);
        assertCellWithNeighborsDies(DEAD, 4);
        assertCellWithNeighborsDies(DEAD, 5);
        assertCellWithNeighborsDies(DEAD, 6);
        assertCellWithNeighborsDies(DEAD, 7);
        assertCellWithNeighborsDies(DEAD, 8);
    }


    private void assertCellWithNeighborsLives(CellState currentState, int liveNeighbours) {
        Cell cell = new Cell();
        cell.state = currentState;
        cell.neighboursAlive = liveNeighbours;

        assertThat(cell.nextState(), is(ALIVE));
    }

    private void assertCellWithNeighborsDies(CellState currentState, int liveNeighbours) {
        Cell cell = new Cell();
        cell.state = currentState;
        cell.neighboursAlive = liveNeighbours;

        assertThat(cell.nextState(), is(DEAD));
    }

}
