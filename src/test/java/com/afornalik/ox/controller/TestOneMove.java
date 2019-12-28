package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.model.board.FieldStatus;
import com.afornalik.ox.model.board.OutOfBoardException;
import com.afornalik.ox.model.board.OverrideFieldException;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class TestOneMove {

    private static final int BOUND_THREE = 3;
    private static final int INDEX_OF_FIELD = 5;
    private static final FieldStatus FIELD_STATUS_X = FieldStatus.X;

    public void shouldCreateMove() {
        //when
        Board board = new Board(BOUND_THREE);
        OneMove oneMove = new OneMove(board);

        //then
        assertThat(oneMove).isNotNull();
    }

    public void shouldChangeFieldStatusOnBoardFromEmptyToX() throws OutOfBoardException, OverrideFieldException {
        //given
        Board board = new Board(BOUND_THREE);
        OneMove oneMove = new OneMove(board);

        //when
        FieldStatus before = board.receiveBoardField(INDEX_OF_FIELD);
        oneMove.makeMove(INDEX_OF_FIELD, FIELD_STATUS_X);
        FieldStatus after = board.receiveBoardField(INDEX_OF_FIELD);

        //then
        assertThat(before).isNotEqualTo(after);
    }
}
