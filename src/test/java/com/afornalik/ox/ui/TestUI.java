package com.afornalik.ox.ui;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.times;

@Test
public class TestUI {

    private static final int BOUND_THREE = 3;

    public void shouldPrintBoardOnConsole() {
        //given
        UIConsole uiConsole = Mockito.mock(UIConsole.class);
        UIDrawBoard uiDrawBoard = Mockito.mock(UIDrawBoard.class);
        UI ui = new UI(uiConsole,uiDrawBoard);

        //when
        ui.say();

        //then
        verify(uiDrawBoard,times(1)).draw();
        verify(uiConsole,times(1)).say(uiDrawBoard.draw());
    }
}
