package com.afornalik.ox.view;

import com.afornalik.ox.Board;
import com.afornalik.ox.Field;
import com.afornalik.ox.OutOfBoardException;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class TestUIDrawBoardNumberCell {
    private static final int BOUND_THREE = 3;

    public void shouldReturnStringWithDrawBoard3x3() {
        //given
        Board board = new Board(BOUND_THREE, 3);
        UIDrawBoard uiDrawBoard = new UIDrawBoardNumberCell(board);

        //when
        String result = uiDrawBoard.drawBoard();

        //then
        assertThat(result).isEqualTo("\n|  1|  2|  3|\n" +
                "|  4|  5|  6|\n" +
                "|  7|  8|  9|\n");
    }

    public void shouldReturnStringWithDrawBoard3x3Filled() throws OutOfBoardException {
        //given
        Board board = new Board(BOUND_THREE, 3);
        board.insertBoardField(0, Field.X);
        board.insertBoardField(1, Field.O);
        UIDrawBoard uiDrawBoard = new UIDrawBoardNumberCell(board);

        //when
        String result = uiDrawBoard.drawBoard();

        //then
        assertThat(result).isEqualTo("\n| X | O |  3|\n" +
                "|  4|  5|  6|\n" +
                "|  7|  8|  9|\n");
    }


}
