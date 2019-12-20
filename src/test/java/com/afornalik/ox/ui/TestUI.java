package com.afornalik.ox.ui;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.BDDMockito.*;

@Test
public class TestUI {

    public void shouldPrintBoardOnConsole() {
        //given
        UIConsole uiConsole = Mockito.mock(UIConsole.class);
        UIDrawBoard uiDrawBoard = Mockito.mock(UIDrawBoard.class);
        UI ui = new UI(uiConsole,uiDrawBoard);

        //when
        ui.printBoard();

        //then
        verify(uiDrawBoard,times(1)).draw();
        verify(uiConsole,times(1)).print(uiDrawBoard.draw());
    }

    public void shouldPrintBoardOnOtherOutput() {
        //given
        UILogger uiLogger = Mockito.mock(UILogger.class);
        UIDrawBoard uiDrawBoard = Mockito.mock(UIDrawBoard.class);
        UI ui = new UI(uiLogger,uiDrawBoard);

        //when
        ui.printBoard();

        //then
        verify(uiDrawBoard,times(1)).draw();
        verify(uiLogger,times(1)).print(uiDrawBoard.draw());
    }
}
