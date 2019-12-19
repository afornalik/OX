package com.afornalik.ox.progress;

import com.afornalik.ox.board.Board;
import com.afornalik.ox.ui.*;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.times;

@Test
public class TestGameProgress {

    private static final int BOUND_THREE = 3;


    public void shouldCreateGame() {
        //given
        Board board = new Board(BOUND_THREE);
        UI ui = Mockito.mock(UI.class);
        GameProgress gameProgress = new GameProgress(ui,board);

        //when
        gameProgress.start();

        //then
        verify(ui, times(1)).printBoard();
    }
}
