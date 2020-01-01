package com.afornalik.ox.model.board;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

@Test
public class TestBoard {

    private static final int BOUND_THREE = 3;
    private static final int INDEX_1 = 1;
    private static final int MINUS_INDEX = -1;
    private static final Field FIELD_STATUS_X = Field.X;


    public void shouldReturnEmptyStatus() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE, 3);

        //when
        Field result = board.receiveBoardField(3);

        //then
        assertThat(result).isEqualTo(Field.EMPTY);
    }


    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowOutOfBoardExceptionWithMinusValue() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE, 3);

        //when
        Field result1 = board.receiveBoardField(-1);
    }

    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowOutOfBoardExceptionWithTooHighValue() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE, 3);

        //when
        Field result1 = board.receiveBoardField(9);
    }

    public void shouldInsertMarkXIntoBoard() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE, 3);

        //when
        board.insertBoardField(INDEX_1, FIELD_STATUS_X);
        Field result = board.receiveBoardField(INDEX_1);

        //then
        assertThat(result).isEqualTo(FIELD_STATUS_X);
    }

    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowOutOfBoardExceptionWhenInsertTooLowValue() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE, 3);

        //when
        board.insertBoardField(MINUS_INDEX, FIELD_STATUS_X);

    }
}
