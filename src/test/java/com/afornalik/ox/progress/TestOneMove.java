package com.afornalik.ox.progress;

import com.afornalik.ox.board.*;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.TreeMap;

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
        Assert.assertNotNull(oneMove);
    }


    public void shouldChangeFieldStatusOnBoardFromEmptyToX() throws OutOfBoardException, OverrideFieldException {
        //given
        Board board = Mockito.mock(Board.class);
        OneMove oneMove = new OneMove(board);

        //when
        oneMove.makeMove(INDEX_OF_FIELD,FIELD_STATUS_X);

        //then
        BDDMockito.verify(board,Mockito.times(1)).insertBoardField(INDEX_OF_FIELD,FIELD_STATUS_X);

    }
}
