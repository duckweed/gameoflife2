package org.dojo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Copyright AdScale GmbH, Germany, 2007
 */
public class GameOfLifeTest {

    @Test
    public void initialStateIsXXX() {
        GameOfLife game = new GameOfLife();
        assertThat(game.getState(), is("XXX"));
    }

    @Test
    public void iterateInitialBlockOfThreeRotates(){
        GameOfLife game = new GameOfLife();
        game.iterate();
        assertThat(game.getState(), is("X\nX\nX"));
    }

    @Test
    public void twoIterationsOfFromItitalStateIsXXX(){
        GameOfLife game = new GameOfLife();
        game.iterate();
        game.iterate();
        assertThat(game.getState(), is("XXX"));
    }

}
