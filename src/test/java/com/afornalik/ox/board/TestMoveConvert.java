package com.afornalik.ox.board;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

@Test
public class TestMoveConvert {

    private static final int BOUND_THREE = 3;
    private static final int INDEX_X_2 = 2;
    private static final int INDEX_Y_2 = 2;



    public void shouldTakeTwoParameterAndTransformThemIntoAppropriateIndexNumber() {
        //given
        MoveConvert moveConvert = new MoveConvert(BOUND_THREE);

        //when
        int result = moveConvert.convertToIndex(INDEX_X_2,INDEX_Y_2);

        //then
        assertThat(result).isEqualTo(4);
    }
}
