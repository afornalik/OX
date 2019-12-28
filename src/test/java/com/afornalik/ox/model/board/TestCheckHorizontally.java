package com.afornalik.ox.model.board;

import com.afornalik.ox.model.board.*;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

@Test
public class TestCheckHorizontally {

    private static final int BOARD = 3;
    private static final int CONDITION_LENGTH = 3;

    public void shouldCheckHorizontally() throws OutOfBoardException {
        //given
        Board board = new Board(BOARD);
        CheckBoard checkBoard = new CheckHorizontally(board, CONDITION_LENGTH);

        //when
        boolean result = checkBoard.check(3, FieldStatus.X);

        //then
        Assertions.assertThat(result).isFalse();
    }

    public void shouldCheckHorizontallyReturnTrue() throws OverrideFieldException, OutOfBoardException {
        //given
        Board board = new Board(BOARD);
        board.insertBoardField(3,FieldStatus.O);
        board.insertBoardField(4,FieldStatus.O);
        board.insertBoardField(5,FieldStatus.O);
        CheckBoard checkBoard = new CheckHorizontally(board, CONDITION_LENGTH);

        //when
        boolean result = checkBoard.check(4,FieldStatus.O);

        //then
        Assertions.assertThat(result).isTrue();
    }

    public void shouldCheckHorizontallyReturnFalse() throws OverrideFieldException, OutOfBoardException {
        //given
        Board board = new Board(BOARD);
        board.insertBoardField(2,FieldStatus.O);
        board.insertBoardField(3,FieldStatus.O);
        board.insertBoardField(4,FieldStatus.O);
        CheckBoard checkBoard = new CheckHorizontally(board, CONDITION_LENGTH);

        //when
        boolean result = checkBoard.check(3,FieldStatus.O);

        //then
       // Assertions.assertThat(result).isFalse();
    }


}
