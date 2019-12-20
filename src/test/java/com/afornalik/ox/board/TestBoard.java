package com.afornalik.ox.board;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.TreeMap;

import static org.testng.Assert.*;

@Test
public class TestBoard {

    private static final int BOUND_FOUR = 4;
    private static final int BOUND_THREE = 3;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final FieldStatus FIELD_STATUS_X = FieldStatus.X;
    private static final FieldStatus FIELD_STATUS_O = FieldStatus.O;

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
    public void shouldThrowOutOfBoardExceptionWithMinusValue() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        BoardField result1 = board.receiveBoardField(-1);
    }

    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowOutOfBoardExceptionWithTooHighValue() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        BoardField result1 = board.receiveBoardField(9);
    }

    public void shouldInsertMarkXIntoBoard() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        board.insertMark(INDEX_1,FIELD_STATUS_X);
        BoardField result = board.receiveBoardField(INDEX_1);

        //then
        Assertions.assertThat(result.showStatus()).isEqualTo(FIELD_STATUS_X);
    }
}
