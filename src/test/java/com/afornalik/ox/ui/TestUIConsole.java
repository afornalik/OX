package com.afornalik.ox.ui;

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
}
