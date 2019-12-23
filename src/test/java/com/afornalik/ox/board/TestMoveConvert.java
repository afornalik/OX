package com.afornalik.ox.board;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

@Test
public class TestMoveConvert {

    private static final int BOUND_THREE = 3;
    private static final int BOUND_SEVENTEEN = 17;
    private static final int INDEX_X_2 = 2;
    private static final int INDEX_Y_2 = 2;
    private static final int INDEX_X_10 = 10;
    private static final int INDEX_Y_13 = 13;

    public void shouldTakeTwoParameterAndTransformThemIntoAppropriateIndexNumber() {
        //given
        MoveConvert moveConvert = new MoveConvert(BOUND_THREE);

        //when
        int result = moveConvert.convertToIndex(INDEX_X_2,INDEX_Y_2);

        //then
        assertThat(result).isEqualTo(4);
    }
    public void shouldTakeTwoParameterAndTransformThemIntoAppropriateIndexNumber2() {
        //given
        MoveConvert moveConvert = new MoveConvert(BOUND_SEVENTEEN);

        //when
        int result = moveConvert.convertToIndex(INDEX_X_10,INDEX_Y_13);

        //then
        assertThat(result).isEqualTo(213);
    }
}
