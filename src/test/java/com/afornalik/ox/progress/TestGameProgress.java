package com.afornalik.ox.progress;

import com.afornalik.ox.ui.*;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.BDDMockito.*;

@Test
public class TestGameProgress {

    public void shouldCreateGame() {
        //given
        UI ui = Mockito.mock(UI.class);
        GameProgress gameProgress = new GameProgress(ui);

        //when
        gameProgress.start();

        //then
        verify(ui, times(1)).printBoard();
    }
}
