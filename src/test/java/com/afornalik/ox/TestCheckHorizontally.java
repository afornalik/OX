package com.afornalik.ox;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class TestCheckHorizontally {

    private static final int BOARD_SIZE = 3;
    private static final int BOARD_SIZE_7 = 7;
    private static final int CONDITION_LENGTH = 3;
    private static final int CONDITION_LENGTH_5 = 5;


    @DataProvider
    public Object[][] winningCombination3x3() {
        return new Object[][]{
                {new int[]{0, 1, 2}, Field.X},
                {new int[]{0, 1, 2}, Field.O},
                {new int[]{3, 4, 5}, Field.X},
                {new int[]{3, 4, 5}, Field.O},
                {new int[]{6, 7, 8}, Field.X},
                {new int[]{6, 7, 8}, Field.O},
        };
    }

    @DataProvider
    public Object[][] notWinningCombination3x3() {
        return new Object[][]{
                {new int[]{2, 3, 4}, Field.O},
                {new int[]{5, 6, 7}, Field.O},
                {new int[]{7, 8, 2}, Field.X},
                {new int[]{1, 3, 5}, Field.O},
        };
    }

    @DataProvider
    public Object[][] notWinningCombinationDifferent3x3() {
        return new Object[][]{
                {new int[]{2, 3, 4}, new Field[]{Field.O, Field.X}},
                {new int[]{5, 6, 7}, new Field[]{Field.O, Field.X}},
                {new int[]{7, 8, 2}, new Field[]{Field.O, Field.X}},
                {new int[]{2, 3, 5}, new Field[]{Field.O, Field.X}},
                {new int[]{1, 4, 2}, new Field[]{Field.O, Field.X}},
                {new int[]{1, 8, 5}, new Field[]{Field.O, Field.X}},
                {new int[]{6, 3, 5}, new Field[]{Field.O, Field.X}},
                {new int[]{2, 7, 5}, new Field[]{Field.O, Field.X}},
        };
    }

    @DataProvider
    public Object[][] notWinningCombinationDifferent5x5() {
        return new Object[][]{
                {new int[]{2, 3, 4, 5, 6}, new Field[]{Field.O, Field.X}},
                {new int[]{7, 8, 9, 10, 11}, new Field[]{Field.O, Field.X}},
                {new int[]{8, 9, 10, 11, 12}, new Field[]{Field.O, Field.X}},
                {new int[]{9, 10, 11, 12, 13}, new Field[]{Field.O, Field.X}},
                {new int[]{14, 15, 16, 17, 18}, new Field[]{Field.O, Field.X}},
                {new int[]{15, 16, 17, 18, 19}, new Field[]{Field.O, Field.X}},
                {new int[]{16, 17, 18, 19, 20}, new Field[]{Field.O, Field.X}},
                {new int[]{30, 34, 33, 32, 31}, new Field[]{Field.O, Field.X}},
        };
    }


    @Test(dataProvider = "winningCombination3x3")
    public void shouldBoardBeInWinState(int[] index, Field field) throws OutOfBoardException {
        //given
        Board board = new Board(BOARD_SIZE, CONDITION_LENGTH);
        board.insertBoardField(index[0], field);
        board.insertBoardField(index[1], field);
        board.insertBoardField(index[2], field);
        BoardChecker boardChecker = new CheckHorizontally(board);

        //when
        boolean result1 = boardChecker.check(index[0], field);
        boolean result2 = boardChecker.check(index[1], field);
        boolean result3 = boardChecker.check(index[2], field);

        //then
        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isTrue();
        Assertions.assertThat(result3).isTrue();
    }

    @Test(dataProvider = "notWinningCombination3x3")
    public void shouldBoardBeInNoWinState(int[] index, Field field) throws OutOfBoardException {
        //given
        Board board = new Board(BOARD_SIZE, CONDITION_LENGTH);
        board.insertBoardField(index[0], field);
        board.insertBoardField(index[1], field);
        board.insertBoardField(index[2], field);
        BoardChecker boardChecker = new CheckHorizontally(board);

        //when
        boolean result1 = boardChecker.check(index[0], field);
        boolean result2 = boardChecker.check(index[1], field);
        boolean result3 = boardChecker.check(index[2], field);

        //then
        Assertions.assertThat(result1).isFalse();
        Assertions.assertThat(result2).isFalse();
        Assertions.assertThat(result3).isFalse();
    }

    @Test(dataProvider = "notWinningCombinationDifferent3x3")
    public void shouldBoardBeInNoWinStateCaseTwo(int[] index, Field[] fields) throws OutOfBoardException {
        //given
        Board board = new Board(BOARD_SIZE, CONDITION_LENGTH);
        board.insertBoardField(index[0], fields[1]);
        board.insertBoardField(index[1], fields[0]);
        board.insertBoardField(index[2], fields[0]);
        BoardChecker boardChecker = new CheckHorizontally(board);

        //when
        boolean result1 = boardChecker.check(index[0], fields[0]);
        boolean result2 = boardChecker.check(index[0], fields[1]);
        boolean result3 = boardChecker.check(index[1], fields[0]);
        boolean result4 = boardChecker.check(index[1], fields[1]);
        boolean result5 = boardChecker.check(index[2], fields[0]);
        boolean result6 = boardChecker.check(index[2], fields[1]);

        //then
        Assertions.assertThat(result1).isFalse();
        Assertions.assertThat(result2).isFalse();
        Assertions.assertThat(result3).isFalse();
        Assertions.assertThat(result4).isFalse();
        Assertions.assertThat(result5).isFalse();
        Assertions.assertThat(result6).isFalse();
    }

    @Test(dataProvider = "notWinningCombinationDifferent5x5")
    public void shouldBoardBeInWinStateBoard7on7Condition5(int[] index, Field[] fields) throws OutOfBoardException {
        //given
        Board board = new Board(BOARD_SIZE_7, CONDITION_LENGTH_5);
        board.insertBoardField(index[0], fields[0]);
        board.insertBoardField(index[1], fields[0]);
        board.insertBoardField(index[2], fields[0]);
        board.insertBoardField(index[3], fields[0]);
        board.insertBoardField(index[4], fields[0]);
        BoardChecker boardChecker = new CheckHorizontally(board);

        //when
        boolean result1 = boardChecker.check(index[0], fields[0]);
        boolean result2 = boardChecker.check(index[1], fields[0]);
        boolean result3 = boardChecker.check(index[2], fields[0]);
        boolean result4 = boardChecker.check(index[3], fields[0]);
        boolean result5 = boardChecker.check(index[4], fields[0]);

        //then
        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isTrue();
        Assertions.assertThat(result3).isTrue();
        Assertions.assertThat(result4).isTrue();
        Assertions.assertThat(result5).isTrue();
    }

}
