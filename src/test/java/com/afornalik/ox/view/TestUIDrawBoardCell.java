package com.afornalik.ox.view;

import com.afornalik.ox.Board;
import com.afornalik.ox.Field;
import com.afornalik.ox.OutOfBoardException;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class TestUIDrawBoardCell {
    private static final int BOUND_THREE = 3;

    public void shouldReturnStringWithDrawBoard3x3() {
        //given
        Board board = new Board(BOUND_THREE, 3);
        UIDrawBoard uiDrawBoard = new UIDrawBoardCell(board);

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
        board.insertField(0, Field.X);
        board.insertField(1, Field.O);
        UIDrawBoard uiDrawBoard = new UIDrawBoardCell(board);

        //when
        String result = uiDrawBoard.drawBoard();

        //then
        assertThat(result).isEqualTo("\n| X | O |  3|\n" +
                "|  4|  5|  6|\n" +
                "|  7|  8|  9|\n");
    }


}
