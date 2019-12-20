package com.afornalik.ox.ui;

import com.afornalik.ox.board.Board;
import com.afornalik.ox.board.FieldStatus;
import com.afornalik.ox.board.OutOfBoardException;
import com.afornalik.ox.board.OverrideFieldException;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class TestUIDrawBoard {

    private static final FieldStatus FIELD_STATUS_X =FieldStatus.X;
    private static final FieldStatus FIELD_STATUS_O =FieldStatus.O;
    private static final int BOUND_THREE = 3;
    private static final int BOUND_TEN = 10;
    private static final int[] INDEX = {0,1,2,3,4,5,6,7,8};

    public void shouldReturnStringWithDrawBoard3x3() throws OutOfBoardException {
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

    public void shouldReturnStringWithTwoMarkDrawBoard3x3() throws OutOfBoardException, OverrideFieldException {
        //given
        Board board = new Board(BOUND_THREE);
        UIDrawBoard uiDrawBoard = new UIDrawBoard(board);

        //when
        board.insertBoardField(INDEX[0],FIELD_STATUS_O);
        board.insertBoardField(INDEX[1],FIELD_STATUS_O);
        String result = uiDrawBoard.draw();

        //then
        assertThat(result).isEqualTo("\n   1 2 3\n" +
                                       "1 |O|O|_|\n"+
                                       "2 |_|_|_|\n"+
                                       "3 |_|_|_|\n");
    }

    public void shouldReturnStringWithFourMarkDrawBoard3x3() throws OutOfBoardException, OverrideFieldException {
        //given
        Board board = new Board(BOUND_THREE);
        UIDrawBoard uiDrawBoard = new UIDrawBoard(board);

        //when
        board.insertBoardField(INDEX[1],FIELD_STATUS_O);
        board.insertBoardField(INDEX[3],FIELD_STATUS_X);
        board.insertBoardField(INDEX[4],FIELD_STATUS_O);
        board.insertBoardField(INDEX[5],FIELD_STATUS_X);
        String result = uiDrawBoard.draw();

        //then
        assertThat(result).isEqualTo("\n   1 2 3\n" +
                                       "1 |_|O|_|\n"+
                                       "2 |X|O|X|\n"+
                                       "3 |_|_|_|\n");
    }




    public void shouldReturnStringWithDrawBoard10x10() throws OutOfBoardException {
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

    public void shouldReturnStringWithMarkedFieldBoard10x10() throws OutOfBoardException, OverrideFieldException {
        //given
        Board board = new Board(BOUND_TEN);
        UIDrawBoard uiDrawBoard = new UIDrawBoard(board);

        //when
        board.insertBoardField(6,FIELD_STATUS_X);
        board.insertBoardField(8,FIELD_STATUS_X);
        board.insertBoardField(15,FIELD_STATUS_O);
        board.insertBoardField(18,FIELD_STATUS_X);
        String result = uiDrawBoard.draw();

        //then
        assertThat(result).isEqualTo("\n   1 2 3 4 5 6 7 8 910\n" +
                                       "1 |_|_|_|_|_|_|X|_|X|_|\n"+
                                       "2 |_|_|_|_|_|O|_|_|X|_|\n"+
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
