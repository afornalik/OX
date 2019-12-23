package com.afornalik.ox.board;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

@Test
public class TestBoard {

    private static final int BOUND_THREE = 3;
    private static final int INDEX_1 = 1;
    private static final int MINUS_INDEX = -1;
    private static final int OVER_MAX_INDEX = 9;
    private static final FieldStatus FIELD_STATUS_X = FieldStatus.X;
    private static final FieldStatus FIELD_STATUS_O = FieldStatus.O;


    public void shouldReturnEmptyStatus() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        FieldStatus result = board.receiveBoardField(3);

        //then
        assertThat(result).isEqualTo(FieldStatus.EMPTY);
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

    public void shouldInsertMarkXIntoBoard() throws OutOfBoardException, OverrideFieldException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        board.insertBoardField(INDEX_1, FIELD_STATUS_X);
        FieldStatus result = board.receiveBoardField(INDEX_1);

        //then
        assertThat(result).isEqualTo(FIELD_STATUS_X);
    }

    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowOutOfBoardExceptionWhenInsertTooLowValue() throws OutOfBoardException, OverrideFieldException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        board.insertBoardField(MINUS_INDEX, FIELD_STATUS_X);
    }

    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowOutOfBoardExceptionWhenInsertTooHighValue() throws OutOfBoardException, OverrideFieldException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        board.insertBoardField(OVER_MAX_INDEX, FIELD_STATUS_X);
    }

    @Test(expectedExceptions = OverrideFieldException.class)
    public void shouldThrowOverrideFieldExceptionWhenInsertTwoSameMarkInField() throws OverrideFieldException, OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        board.insertBoardField(INDEX_1,FIELD_STATUS_X);
        board.insertBoardField(INDEX_1,FIELD_STATUS_X);
    }

    @Test(expectedExceptions = OverrideFieldException.class)
    public void shouldThrowOverrideFieldExceptionWhenInsertTwoDifferentMarkInField() throws OverrideFieldException, OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        board.insertBoardField(INDEX_1,FIELD_STATUS_X);
        board.insertBoardField(INDEX_1,FIELD_STATUS_O);
    }
}
