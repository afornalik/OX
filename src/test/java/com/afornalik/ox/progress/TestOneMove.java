package com.afornalik.ox.progress;

import com.afornalik.ox.board.Board;
import com.afornalik.ox.board.FieldStatus;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test
public class TestOneMove {

    private static final int BOUND_THREE = 3;
    private static final int INDEX_OF_FIELD = 5;
    private static final FieldStatus FIELD_STATUS_X = FieldStatus.X;

    public void shouldCreateMove() {
        //when
        Board board = new Board(BOUND_THREE);
        OneMove oneMove = new OneMove(board,INDEX_OF_FIELD,FIELD_STATUS_X);

        //then
        Assert.assertNotNull(oneMove);
    }

}
