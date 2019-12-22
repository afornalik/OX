package com.afornalik.ox.board;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;
import static org.testng.Assert.*;

@Test
public class TestBoard {

    private static final int BOUND_THREE = 3;
    private static final int INDEX_1 = 1;
    private static final int MINUS_INDEX = -1;
    private static final FieldStatus FIELD_STATUS_X = FieldStatus.X;


    public void shouldReturnNullInsteadOfBoardField() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        FieldStatus result = board.receiveBoardField(3);

        //then
        assertNull(result);
    }


    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowOutOfBoardExceptionWithMinusValue() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        FieldStatus result1 = board.receiveBoardField(-1);
    }

    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowOutOfBoardExceptionWithTooHighValue() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        FieldStatus result1 = board.receiveBoardField(9);
    }

    public void shouldInsertMarkXIntoBoard() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        board.insertBoardField(INDEX_1, FIELD_STATUS_X);
        FieldStatus result = board.receiveBoardField(INDEX_1);

        //then
        assertThat(result).isEqualTo(FIELD_STATUS_X);
    }

    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowOutOfBoardExceptionWhenInsertTooLowValue() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        board.insertBoardField(MINUS_INDEX, FIELD_STATUS_X);

    }
}
