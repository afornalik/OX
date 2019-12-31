package com.afornalik.ox.model.board;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

@Test
public class TestCheckHorizontally {

    private static final int BOARD_SIZE = 3;
    private static final int CONDITION_LENGTH = 3;
    private static final FieldStatus FIELD_STATUS_X = FieldStatus.X;
    private static final FieldStatus FIELD_STATUS_O = FieldStatus.O;

    @Test
    public void shouldBoardBeInWinStateCaseOne() throws OutOfBoardException {
        //given
        Board board = new Board(BOARD_SIZE);
        board.insertBoardField(0,FIELD_STATUS_X);
        board.insertBoardField(1,FIELD_STATUS_X);
        board.insertBoardField(2,FIELD_STATUS_X);
        BoardChecker boardChecker = new CheckHorizontally(board,CONDITION_LENGTH);

        //when
        boolean result1 = boardChecker.check(0,FIELD_STATUS_X);
        boolean result2 = boardChecker.check(1,FIELD_STATUS_X);
        boolean result3 = boardChecker.check(2,FIELD_STATUS_X);

        //then
        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isTrue();
        Assertions.assertThat(result3).isTrue();
    }

    @Test
    public void shouldBoardBeInWinStateCaseTwo() throws OutOfBoardException {
        //given
        Board board = new Board(BOARD_SIZE);
        board.insertBoardField(3,FIELD_STATUS_O);
        board.insertBoardField(4,FIELD_STATUS_O);
        board.insertBoardField(5,FIELD_STATUS_O);
        BoardChecker boardChecker = new CheckHorizontally(board,CONDITION_LENGTH);

        //when
        boolean result1 = boardChecker.check(3,FIELD_STATUS_O);
        boolean result2 = boardChecker.check(4,FIELD_STATUS_O);
        boolean result3 = boardChecker.check(5,FIELD_STATUS_O);

        //then
        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isTrue();
        Assertions.assertThat(result3).isTrue();
    }

    @Test
    public void shouldBoardBeInWinStateCaseThree() throws OutOfBoardException {
        //given
        Board board = new Board(BOARD_SIZE);
        board.insertBoardField(6,FIELD_STATUS_X);
        board.insertBoardField(8,FIELD_STATUS_X);
        board.insertBoardField(7,FIELD_STATUS_X);
        BoardChecker boardChecker = new CheckHorizontally(board,CONDITION_LENGTH);

        //when
        boolean result1 = boardChecker.check(7,FIELD_STATUS_X);
        boolean result2 = boardChecker.check(8,FIELD_STATUS_X);
        boolean result3 = boardChecker.check(6,FIELD_STATUS_X);

        //then
        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isTrue();
        Assertions.assertThat(result3).isTrue();
    }

    @Test
    public void shouldBoardBeInNoWinStateCaseOne() throws OutOfBoardException {
        //given
        Board board = new Board(BOARD_SIZE);
        board.insertBoardField(2,FIELD_STATUS_X);
        board.insertBoardField(3,FIELD_STATUS_X);
        board.insertBoardField(4,FIELD_STATUS_X);
        BoardChecker boardChecker = new CheckHorizontally(board,CONDITION_LENGTH);

        //when
        boolean result1 = boardChecker.check(2,FIELD_STATUS_X);
        boolean result2 = boardChecker.check(3,FIELD_STATUS_X);
        boolean result3 = boardChecker.check(4,FIELD_STATUS_X);

        //then
        Assertions.assertThat(result1).isFalse();
        Assertions.assertThat(result2).isFalse();
        Assertions.assertThat(result3).isFalse();
    }
}
