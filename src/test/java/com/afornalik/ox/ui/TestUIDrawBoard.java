package com.afornalik.ox.ui;

import com.afornalik.ox.board.Board;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class TestUIDrawBoard {

    private static final int BOUND_THREE = 3;
    private static final int BOUND_TEN = 10;

    public void shouldReturnStringWithDrawBoard3x3() {
        //given
        Board board = new Board(BOUND_THREE);
        UIDrawBoard uiDrawBoard = new UIDrawBoard(board);

        //when
        String result = uiDrawBoard.draw();

        //then
        assertThat(result).isEqualTo("\n   1 2 3\n" +
                                       "1 |_|_|_|\n"+
                                       "2 |_|_|_|\n"+
                                       "3 |_|_|_|\n");
    }

    public void shouldReturnStringWithDrawBoard10x10() {
        //given
        Board board = new Board(BOUND_TEN);
        UIDrawBoard uiDrawBoard = new UIDrawBoard(board);

        //when
        String result = uiDrawBoard.draw();

        //then
        assertThat(result).isEqualTo("\n   1 2 3 4 5 6 7 8 910\n" +
                                       "1 |_|_|_|_|_|_|_|_|_|_|\n"+
                                       "2 |_|_|_|_|_|_|_|_|_|_|\n"+
                                       "3 |_|_|_|_|_|_|_|_|_|_|\n"+
                                       "4 |_|_|_|_|_|_|_|_|_|_|\n"+
                                       "5 |_|_|_|_|_|_|_|_|_|_|\n"+
                                       "6 |_|_|_|_|_|_|_|_|_|_|\n"+
                                       "7 |_|_|_|_|_|_|_|_|_|_|\n"+
                                       "8 |_|_|_|_|_|_|_|_|_|_|\n"+
                                       "9 |_|_|_|_|_|_|_|_|_|_|\n"+
                                       "10|_|_|_|_|_|_|_|_|_|_|\n");
    }



}
