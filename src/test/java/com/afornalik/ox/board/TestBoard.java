package com.afornalik.ox.board;

import com.afornalik.ox.board.Board;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class TestBoard {

    private static final int BOUND = 3;

    public void shouldCreateBoard3x3() {
        //given
        Board board = new Board();

        //when
        board.setDimension(BOUND);

        //then
        assertEquals(board.getBound(),BOUND);
    }
}
