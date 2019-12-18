package com.afornalik.ox.ui;

import com.afornalik.ox.board.Board;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

@Test
public class TestUIDrawBoard {

    private static final int BOUND_THREE = 3;

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

}
