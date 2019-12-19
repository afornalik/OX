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


    public void shouldReturnEmptyStatusFromBoardFieldAfterInitialization() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);
        board.initializeAllField(new TreeMap<>());

        //when
        BoardField result1 = board.receiveBoardField(0);
        BoardField result2 = board.receiveBoardField(4);
        BoardField result3 = board.receiveBoardField(8);
        BoardField result4 = board.receiveBoardField(3);
        BoardField result5 = board.receiveBoardField(7);

        //then
        assertEquals(result1.showStatus(),FieldStatus.EMPTY);
        assertEquals(result2.showStatus(),FieldStatus.EMPTY);
        assertEquals(result3.showStatus(),FieldStatus.EMPTY);
        assertNotEquals(result4.showStatus(),FieldStatus.O);
        assertNotEquals(result5.showStatus(),FieldStatus.X);
    }


    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowOutOfBoardExceptionWithMinusValue() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);
        board.initializeAllField(new TreeMap<>());

        //when
        BoardField result1 = board.receiveBoardField(-1);
    }

    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowOutOfBoardExceptionWithTooHighValue() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);
        board.initializeAllField(new TreeMap<>());

        //when
        BoardField result1 = board.receiveBoardField(9);
    }
}
