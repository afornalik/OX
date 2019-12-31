package com.afornalik.ox.model.board;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

@Test
public class TestCheckHorizontally {

    private static final int BOARD_SIZE = 3;
    private static final int CONDITION_LENGTH = 3;
    private static final FieldStatus FIELD_STATUS_X = FieldStatus.X;

    @Test
    public void shouldBoardBeInWinStateCaseOne() throws OutOfBoardException {
        //given
        Board board = new Board(BOARD_SIZE);
        board.insertBoardField(0,FIELD_STATUS_X);
        board.insertBoardField(1,FIELD_STATUS_X);
        board.insertBoardField(2,FIELD_STATUS_X);
        BoardChecker boardChecker = new CheckHorizontally(board,CONDITION_LENGTH);

        //when
        boolean result = boardChecker.check(0,FIELD_STATUS_X);

        //then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void shouldBoardBeInWinStateCaseTwo() throws OutOfBoardException {
        //given
        Board board = new Board(BOARD_SIZE);
        board.insertBoardField(3,FIELD_STATUS_X);
        board.insertBoardField(4,FIELD_STATUS_X);
        board.insertBoardField(5,FIELD_STATUS_X);
        BoardChecker boardChecker = new CheckHorizontally(board,CONDITION_LENGTH);

        //when
        boolean result = boardChecker.check(3,FIELD_STATUS_X);

        //then
        Assertions.assertThat(result).isTrue();
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
        boolean result = boardChecker.check(8,FIELD_STATUS_X);

        //then
        Assertions.assertThat(result).isTrue();
    }
}
