package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.model.board.FieldStatus;
import com.afornalik.ox.model.board.OutOfBoardException;
import com.afornalik.ox.model.player.PlayerContainer;
import com.afornalik.ox.view.UIConsole;
import com.afornalik.ox.view.UIOperations;
import com.afornalik.ox.view.draw.UIDrawBoardCellNumerate;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class TestSkirmishController {

    private static final Board BOARD = new Board(5);
    private static final Board BOARD_THREE = new Board(3);
    private static final PlayerContainer PLAYER_CONTAINER = new PlayerContainer();

    public void shouldUserMakeAMove() throws OutOfBoardException {
        //given
        UIOperations uiConsole = Mockito.mock(UIConsole.class);
        Mockito.when(uiConsole.readNumber()).thenReturn(1);
        SkirmishController skirmishController = new SkirmishController(uiConsole, new Board(5), PLAYER_CONTAINER);

        //when
        Board result = skirmishController.makeMove(FieldStatus.X);
        BOARD.insertBoardField(1, FieldStatus.X);

        //then
        assertThat(result.receiveBoardField(0)).isEqualTo(FieldStatus.X);
        assertThat(result.receiveBoardField(0)).isEqualTo(BOARD.receiveBoardField(1));
    }

    public void shouldBothPlayerMakeAMove() throws OutOfBoardException {
        //given
        Board board = new Board(5);
        Scanner scanner = Mockito.mock(Scanner.class);
        Mockito.when(scanner.next()).thenReturn("1","2");
        UIOperations uiConsole =new UIConsole(new UIDrawBoardCellNumerate(board),scanner);
        SkirmishController skirmishController = new SkirmishController(uiConsole, board, PLAYER_CONTAINER);

        //when
        Board result = skirmishController.makeTurn();
        BOARD.insertBoardField(1, FieldStatus.X);
        BOARD.insertBoardField(2, FieldStatus.O);

        //then
        assertThat(result.receiveBoardField(0)).isEqualTo(FieldStatus.X);
        assertThat(result.receiveBoardField(1)).isEqualTo(FieldStatus.O);
        assertThat(result.receiveBoardField(0)).isEqualTo(BOARD.receiveBoardField(1));
        assertThat(result.receiveBoardField(1)).isEqualTo(BOARD.receiveBoardField(2));
    }

    @Test(enabled = false)
    public void shouldAllFieldBeMarked() throws OutOfBoardException {
        //given
        UIOperations uiConsole = Mockito.mock(UIConsole.class);
        Mockito.when(uiConsole.readNumber()).thenReturn(1,2,3,4,5,6,7,8,9);
        SkirmishController skirmishController = new SkirmishController(uiConsole, new Board(3), PLAYER_CONTAINER);

        //when
        Board result = skirmishController.makeTurn();
        BOARD_THREE.insertBoardField(0, FieldStatus.X);
        BOARD_THREE.insertBoardField(1, FieldStatus.O);
        BOARD_THREE.insertBoardField(2, FieldStatus.X);
        BOARD_THREE.insertBoardField(3, FieldStatus.O);
        BOARD_THREE.insertBoardField(4, FieldStatus.X);
        BOARD_THREE.insertBoardField(5, FieldStatus.O);
        BOARD_THREE.insertBoardField(6, FieldStatus.X);
        BOARD_THREE.insertBoardField(7, FieldStatus.O);
        BOARD_THREE.insertBoardField(8, FieldStatus.X);

        //then
        assertThat(result.receiveBoardField(0)).isEqualTo(BOARD_THREE.receiveBoardField(0));
        assertThat(result.receiveBoardField(1)).isEqualTo(BOARD_THREE.receiveBoardField(1));
        assertThat(result.receiveBoardField(2)).isEqualTo(BOARD_THREE.receiveBoardField(2));
        assertThat(result.receiveBoardField(3)).isEqualTo(BOARD_THREE.receiveBoardField(3));
        assertThat(result.receiveBoardField(4)).isEqualTo(BOARD_THREE.receiveBoardField(4));
        assertThat(result.receiveBoardField(5)).isEqualTo(BOARD_THREE.receiveBoardField(5));
        assertThat(result.receiveBoardField(6)).isEqualTo(BOARD_THREE.receiveBoardField(6));
        assertThat(result.receiveBoardField(7)).isEqualTo(BOARD_THREE.receiveBoardField(7));
        assertThat(result.receiveBoardField(8)).isEqualTo(BOARD_THREE.receiveBoardField(8));
        assertThat(result.receiveNumberOfEmptyFields()).isEqualTo(0);
    }

}
