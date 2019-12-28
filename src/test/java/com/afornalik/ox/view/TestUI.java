package com.afornalik.ox.view;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.model.board.OutOfBoardException;
import com.afornalik.ox.view.draw.UIDrawBoard;
import com.afornalik.ox.view.draw.UIDrawBoardSideNumerate;
import org.assertj.core.api.Assertions;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.BDDMockito.verify;
import static org.mockito.BDDMockito.times;
import java.util.Scanner;

import static org.mockito.BDDMockito.*;

@Test
public class TestUI {

    private static final String NUMBER_VALUE="42";
    private static final String STRING_VALUE="abc";

    public void shouldPrintBoardOnConsole() throws OutOfBoardException {
        //given
        UIDrawBoard uiDrawBoard = Mockito.mock(UIDrawBoard.class);
        UIOperations ui = new UIConsole(uiDrawBoard, new Scanner(System.in));

        //when
        ui.drawBoard();

        //then
        verify(uiDrawBoard, times(1)).drawBoard();
    }



    public void shouldReadNumberFromUser() {
        //given
        Scanner scanner = Mockito.mock(Scanner.class);
        when(scanner.next()).thenReturn(NUMBER_VALUE);
        UIOperations uiInput = new UIConsole(new UIDrawBoardSideNumerate(new Board(5)),scanner);

        //when
        int result = uiInput.readNumber();

        //then
        Assertions.assertThat(result).isEqualTo(Integer.parseInt(NUMBER_VALUE));
    }
}
