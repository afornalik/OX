package com.afornalik.ox.checker;

import com.afornalik.ox.Board;
import com.afornalik.ox.Field;
import com.afornalik.ox.OutOfBoardException;
import com.afornalik.ox.checker.BoardChecker;
import com.afornalik.ox.checker.CheckVertically;
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
    @DataProvider
    public Object[][] winningCombination5x5() {
        return new Object[][]{
                {new int[]{0, 7, 14, 21, 28}, new Field[]{Field.O, Field.X}},
                {new int[]{14, 21, 28, 35, 42}, new Field[]{Field.O, Field.X}},
                {new int[]{2, 9, 16, 23, 30}, new Field[]{Field.O, Field.X}},
                {new int[]{17, 24, 31, 38, 45}, new Field[]{Field.O, Field.X}},
                {new int[]{11, 18, 25, 32, 39}, new Field[]{Field.O, Field.X}},
                {new int[]{5, 12, 19, 26, 33}, new Field[]{Field.O, Field.X}},
                {new int[]{6, 13, 20, 27, 34}, new Field[]{Field.O, Field.X}},
                {new int[]{20, 27, 34, 41, 48}, new Field[]{Field.O, Field.X}},
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

    @Test(dataProvider = "winningCombination5x5")
    public void shouldBoardBeInWinStateBoard7on7Condition5(int[] index, Field[] fields) throws OutOfBoardException {
        //given
        Board board = new Board(BOARD_SIZE_7, CONDITION_LENGTH_5);
        board.insertField(index[0], fields[0]);
        board.insertField(index[1], fields[0]);
        board.insertField(index[2], fields[0]);
        board.insertField(index[3], fields[0]);
        board.insertField(index[4], fields[0]);
        BoardChecker boardChecker = new CheckVertically(board);

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