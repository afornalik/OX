package com.afornalik.ox;

import com.afornalik.ox.Board;
import com.afornalik.ox.Field;
import com.afornalik.ox.OutOfBoardException;
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
        Field result = board.receiveField(3);

        //then
        assertThat(result).isEqualTo(Field.EMPTY);
    }


    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowOutOfBoardExceptionWithMinusValue() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE, 3);

        //when
        Field result1 = board.receiveField(-1);
    }

    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowOutOfBoardExceptionWithTooHighValue() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE, 3);

        //when
        Field result1 = board.receiveField(9);
    }

    public void shouldInsertMarkXIntoBoard() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE, 3);

        //when
        board.insertField(INDEX_1, FIELD_STATUS_X);
        Field result = board.receiveField(INDEX_1);

        //then
        assertThat(result).isEqualTo(FIELD_STATUS_X);
    }

    @Test(expectedExceptions = OutOfBoardException.class)
    public void shouldThrowOutOfBoardExceptionWhenInsertTooLowValue() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE, 3);

        //when
        board.insertField(MINUS_INDEX, FIELD_STATUS_X);

    }
}
