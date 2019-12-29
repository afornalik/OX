package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.view.UIConsole;
import com.afornalik.ox.view.UIOperations;
import org.assertj.core.api.Assertions;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.testng.annotations.Test;

@Test
public class TestBoardController {

    private static int BOARD_SIZE = 3;
    public void shouldCreateBoard() {
        //given
        UIOperations uiOperations = Mockito.mock(UIConsole.class);
        BDDMockito.when(uiOperations.readNumber()).thenReturn(BOARD_SIZE);
        BoardController boardController = new BoardController(uiOperations);

        //when
        Board result = boardController.createBoard();

        //then
        Assertions.assertThat(result).isEqualTo(new Board(BOARD_SIZE));
    }


}
