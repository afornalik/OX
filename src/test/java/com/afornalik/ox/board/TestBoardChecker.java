package com.afornalik.ox.board;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

@Test
public class TestBoardChecker {

    private static final int BOARD = 3;
    private static final int CONDITION_LENGTH = 3;

    public void shouldCheckHorizontally() {
        //given
        Board board = new Board(BOARD);
        CheckBoard checkBoard = new CheckHorizontally(board, CONDITION_LENGTH);

        //when
        boolean result = checkBoard.check();

        //then
        Assertions.assertThat(result).isFalse();
    }


}
