package com.afornalik.ox.progress;

import com.afornalik.ox.board.*;
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


    public void shouldChangeFieldStatusOnBoardFromEmptyToX()  {

    }
}
