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


    public void shouldReturnNullInsteadOfBoardField() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        BoardField result = board.receiveBoardField(3);

        //then
        assertNull(result);
    }


    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowExceptionOutOfBoardExceptionWithMinusValue() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        BoardField result1 = board.receiveBoardField(-1);
    }

    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowExceptionOutOfBoardExceptionWithTooHighValue() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        BoardField result1 = board.receiveBoardField(9);
    }
}
