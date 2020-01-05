package com.afornalik.ox;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class TestCheckVertically {

    private static final int BOARD_SIZE = 3;
    private static final int BOARD_SIZE_7 = 7;
    private static final int CONDITION_LENGTH = 3;
    private static final int CONDITION_LENGTH_5 = 5;


    @DataProvider
    public Object[][] winningCombination3x3() {
        return new Object[][]{
                {new int[]{0, 3, 6}, Field.X},
                {new int[]{0, 3, 6}, Field.O},
                {new int[]{1, 4, 7}, Field.X},
                {new int[]{1, 4, 7}, Field.O},
                {new int[]{2, 5, 8}, Field.X},
                {new int[]{2, 5, 8}, Field.O},
        };
    }



    @Test(dataProvider = "winningCombination3x3")
    public void shouldBoardBeInWinState(int[] index, Field field) throws OutOfBoardException {
        //given
        Board board = new Board(BOARD_SIZE, CONDITION_LENGTH);
        board.insertField(index[0], field);
        board.insertField(index[1], field);
        board.insertField(index[2], field);
        BoardChecker boardChecker = new CheckVertically(board);

        //when
        boolean result1 = boardChecker.check(index[0], field);
        boolean result2 = boardChecker.check(index[1], field);
        boolean result3 = boardChecker.check(index[2], field);

        //then
        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isTrue();
        Assertions.assertThat(result3).isTrue();
    }

}