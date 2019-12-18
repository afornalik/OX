package com.afornalik.ox.board;

import org.testng.annotations.Test;

import java.util.TreeMap;

import static org.testng.Assert.*;

@Test
public class TestBoard {

    private static final int BOUND_FOUR = 4;
    private static final int BOUND_THREE = 3;

    public void shouldCreateBoard3x3() {
        //when
        Board board = new Board(BOUND_THREE);

        //then
        assertEquals(board.getBound(),BOUND_THREE);
    }

    public void shouldCreateBoard4x4() {
        //when
        Board board = new Board(BOUND_FOUR);

        //then
        assertEquals(board.getBound(),BOUND_FOUR);
    }

    public void shouldCreateAndInitializeBoard() {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        boolean result = board.initializeAllField(new TreeMap<>());

        //then
        assertTrue(result);
    }

    public void shouldReturnEmptyStatusFromBoardFieldAfterInitialization() {
        //given
        Board board = new Board(BOUND_THREE);
        board.initializeAllField(new TreeMap<>());

        //when
        BoardField result = board.receiveBoardField(0);

        //then
        assertEquals(result.showStatus(),FieldStatus.EMPTY);
    }
}
