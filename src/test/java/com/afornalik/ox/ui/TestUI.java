package com.afornalik.ox.ui;

import com.afornalik.ox.board.OutOfBoardException;
import org.assertj.core.api.Assertions;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.Scanner;

import static org.mockito.BDDMockito.*;

@Test
public class TestUI {

    private static final String NUMBER_VALUE="42";
    private static final String STRING_VALUE="abc";

    public void shouldPrintBoardOnConsole() throws OutOfBoardException {
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

    public void shouldPrintBoardOnOtherOutput() throws OutOfBoardException {
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

    public void shouldReadNumberFromUser() {
        //given
        Scanner scanner = Mockito.mock(Scanner.class);
        when(scanner.next()).thenReturn(NUMBER_VALUE);
        UIOperations uiInput = new UIConsole(scanner);
        UI ui = new UI(uiInput,null);

        //when
        int result = ui.readNumber();

        //then
        Assertions.assertThat(result).isEqualTo(Integer.parseInt(NUMBER_VALUE));
    }
}
