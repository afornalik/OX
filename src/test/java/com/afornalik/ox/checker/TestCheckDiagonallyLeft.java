package com.afornalik.ox.checker;

import com.afornalik.ox.Board;
import com.afornalik.ox.Field;
import com.afornalik.ox.OutOfBoardException;
import com.afornalik.ox.checker.BoardChecker;
import com.afornalik.ox.checker.CheckDiagonallyLeft;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class TestCheckDiagonallyLeft {

    private static final int BOARD_SIZE = 3;
    private static final int BOARD_SIZE_7 = 7;
    private static final int CONDITION_LENGTH = 3;
    private static final int CONDITION_LENGTH_5 = 5;

    @DataProvider
    public Object[][] winningCombination5x5() {
        return new Object[][]{
                {new int[]{0, 8, 16, 24, 32}, new Field[]{Field.O, Field.X}},
                {new int[]{8, 16, 24, 32, 40}, new Field[]{Field.O, Field.X}},
                {new int[]{16, 24, 32, 40, 48}, new Field[]{Field.O, Field.X}},
                {new int[]{2, 10, 18, 26, 34}, new Field[]{Field.O, Field.X}},
                {new int[]{9, 17, 25, 33, 41}, new Field[]{Field.O, Field.X}},
                {new int[]{7, 15, 23, 31, 39}, new Field[]{Field.O, Field.X}},
                {new int[]{15, 23, 31, 39, 47}, new Field[]{Field.O, Field.X}},
                {new int[]{14, 22, 30, 38, 46}, new Field[]{Field.O, Field.X}},
        };
    }

    @Test
    public void shouldBoardBeInWinState() throws OutOfBoardException {
        //given
        Board board = new Board(BOARD_SIZE, CONDITION_LENGTH);
        board.insertField(0, Field.O);
        board.insertField(4, Field.O);
        board.insertField(8, Field.O);
        BoardChecker boardChecker = new CheckDiagonallyLeft(board);

        //when
        boolean result1 = boardChecker.check(0, Field.O);
        boolean result2 = boardChecker.check(4, Field.O);
        boolean result3 = boardChecker.check(8, Field.O);

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
        BoardChecker boardChecker = new CheckDiagonallyLeft(board);

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
