package com.afornalik.ox.view;

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

    private static final String NUMBER_VALUE = "42";
    private static final String DUMMY_STRING = "Some dummy string to print";

    public void shouldPrintString() {
        //given
        Scanner scanner = new Scanner(System.in);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        UISimple uiConsole = new UISimple(scanner);

        //when
        uiConsole.print(DUMMY_STRING);

        //then
        assertThat(byteArrayOutputStream.toString()).isEqualTo(DUMMY_STRING);
    }

    public void shouldReceiveConsoleInputFromUser() {
        //given
        Scanner scanner = Mockito.mock(Scanner.class);
        Mockito.when(scanner.next()).thenReturn(DUMMY_STRING);
        UISimple uiConsole = new UISimple(scanner);

        //when
        String result = uiConsole.read();

        //then
        Assertions.assertThat(result).isEqualTo(DUMMY_STRING);

    }

    public void shouldReadNumberFromUser() {
        //given
        Scanner scanner = Mockito.mock(Scanner.class);
        when(scanner.next()).thenReturn(NUMBER_VALUE);
        UISimple uiInput = new UISimple(scanner);

        //when
        int result = uiInput.readNumber();

        //then
        Assertions.assertThat(result).isEqualTo(Integer.parseInt(NUMBER_VALUE));
    }


}
