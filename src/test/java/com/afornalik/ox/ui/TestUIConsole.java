package com.afornalik.ox.ui;

import org.assertj.core.api.Assertions;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class TestUIConsole {

    private static final String DUMMY_STRING = "Some dummy string to print";

    public void shouldPrintOutGivenString() {
        //given
        Scanner scanner = new Scanner(System.in);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        UIConsole uiConsole = new UIConsole(scanner);

        //when
        uiConsole.print(DUMMY_STRING);

        //then
        assertThat(byteArrayOutputStream.toString()).isEqualTo(DUMMY_STRING);
    }

    public void shouldReceiveConsoleInputFromUser() {
        //given
        Scanner scanner = Mockito.mock(Scanner.class);
        Mockito.when(scanner.next()).thenReturn(DUMMY_STRING);
        UIOperations uiInput = new UIConsole(scanner);

        //when
        String result = uiInput.read();

        //then
        Assertions.assertThat(result).isEqualTo(DUMMY_STRING);

    }



}
