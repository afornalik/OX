package com.afornalik.ox.board;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

@Test
public class TestBoard {

    private static final FieldStatus FIELD_STATUS_O = FieldStatus.O;
    private static final FieldStatus FIELD_STATUS_X = FieldStatus.X;
    private static final int BOUND_THREE = 3;
    private static final int INDEX_1 = 1;

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
        board.insertBoardField(2,1, FIELD_STATUS_X);
        FieldStatus result = board.receiveBoardField(INDEX_1);

        //then
        assertThat(result).isEqualTo(FIELD_STATUS_X);
    }

    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowOutOfBoardExceptionWhenInsertTooLowValue() throws OutOfBoardException, OverrideFieldException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        board.insertBoardField(-1,-1, FIELD_STATUS_X);
    }

    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowOutOfBoardExceptionWhenInsertTooHighValue() throws OutOfBoardException, OverrideFieldException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        board.insertBoardField(10,10, FIELD_STATUS_X);
    }

    @Test(expectedExceptions = OverrideFieldException.class)
    public void shouldThrowOverrideFieldExceptionWhenInsertTwoSameMarkInField() throws OverrideFieldException, OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        board.insertBoardField(1,1,FIELD_STATUS_X);
        board.insertBoardField(1,1,FIELD_STATUS_X);
    }

    @Test(expectedExceptions = OverrideFieldException.class)
    public void shouldThrowOverrideFieldExceptionWhenInsertTwoDifferentMarkInField() throws OverrideFieldException, OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        board.insertBoardField(1,1,FIELD_STATUS_X);
        board.insertBoardField(1,1,FIELD_STATUS_O);
    }

    public void shouldTakeTwoParameterAndTransformThemIntoAppropriateIndexNumber() throws OverrideFieldException, OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        board.insertBoardField(1,1,FIELD_STATUS_X);
        FieldStatus result = board.receiveBoardField(0);

        //then
        assertThat(result).isEqualTo(FIELD_STATUS_X);
    }
    public void shouldTakeTwoParameterAndTransformThemIntoAppropriateIndexNumber2() throws OverrideFieldException, OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE);

        //when
        board.insertBoardField(2,3,FIELD_STATUS_O);
        FieldStatus result = board.receiveBoardField(7);

        //then
        assertThat(result).isEqualTo(FIELD_STATUS_O);
    }
}
