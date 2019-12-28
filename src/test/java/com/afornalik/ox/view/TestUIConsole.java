package com.afornalik.ox.view;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.view.draw.UIDrawBoardSideNumerate;
import org.assertj.core.api.Assertions;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@Test
public class TestUIConsole {

    private static final String DUMMY_STRING = "Some dummy string to print";
    private static final String NUMBER_VALUE = "42";

    public void shouldPrintOutGivenString() {
        //given
        Scanner scanner = new Scanner(System.in);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        UIConsole uiConsole = new UIConsole(new UIDrawBoardSideNumerate(new Board(5)), scanner);

        //when
        uiConsole.print(DUMMY_STRING);

        //then
        assertThat(byteArrayOutputStream.toString()).isEqualTo(DUMMY_STRING);
    }

    public void shouldReceiveConsoleInputFromUser() {
        //given
        Scanner scanner = Mockito.mock(Scanner.class);
        Mockito.when(scanner.next()).thenReturn(DUMMY_STRING);
        UIConsole uiConsole = new UIConsole(new UIDrawBoardSideNumerate(new Board(5)), scanner);

        //when
        String result = uiConsole.read();

        //then
        Assertions.assertThat(result).isEqualTo(DUMMY_STRING);

    }

    public void shouldReadNumberFromUser() {
        //given
        Scanner scanner = Mockito.mock(Scanner.class);
        when(scanner.next()).thenReturn(NUMBER_VALUE);
        UIOperations uiInput = new UIConsole(new UIDrawBoardSideNumerate(new Board(5)), scanner);

        //when
        int result = uiInput.readNumber();

        //then
        Assertions.assertThat(result).isEqualTo(Integer.parseInt(NUMBER_VALUE));
    }


}
