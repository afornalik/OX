package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.model.board.FieldStatus;
import com.afornalik.ox.model.board.OutOfBoardException;
import com.afornalik.ox.model.player.PlayerContainer;
import com.afornalik.ox.view.UIConsole;
import com.afornalik.ox.view.UIOperations;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class TestSkirmishController {

    private static final Board BOARD = new Board(5);
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
        UIOperations uiConsole = Mockito.mock(UIConsole.class);
        Mockito.when(uiConsole.readNumber()).thenReturn(1,2);
        SkirmishController skirmishController = new SkirmishController(uiConsole, new Board(5), PLAYER_CONTAINER);

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

}
