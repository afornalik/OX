package com.afornalik.ox.view;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.model.board.FieldStatus;
import com.afornalik.ox.model.board.OutOfBoardException;
import com.afornalik.ox.view.draw.UIDrawBoard;
import com.afornalik.ox.view.draw.UIDrawBoardCellNumerate;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class TestUIDrawBoardCellNumerate {
    private static final int BOUND_THREE = 3;

    public void shouldReturnStringWithDrawBoard3x3() {
        //given
        Board board = new Board(BOUND_THREE, 3);
        UIDrawBoard uiDrawBoard = new UIDrawBoardCellNumerate(board);

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
        board.insertBoardField(0, FieldStatus.X);
        board.insertBoardField(1, FieldStatus.O);
        UIDrawBoard uiDrawBoard = new UIDrawBoardCellNumerate(board);

        //when
        String result = uiDrawBoard.drawBoard();

        //then
        assertThat(result).isEqualTo("\n| X | O |  3|\n" +
                "|  4|  5|  6|\n" +
                "|  7|  8|  9|\n");
    }


}
