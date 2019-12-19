package com.afornalik.ox.ui;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

@Test
public class TestUIConsole {

    private static final String DUMMY_STRING = "Some dummy string to print";

    public void shouldPrintGreetingToUser() {
        //given
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        UIConsole uiConsole = new UIConsole();

        //when
        uiConsole.sayHello();

        //then
        assertEquals(byteArrayOutputStream.toString() , "Welcome to game OX");
    }

    public void shouldPrintOutGivenString() {
        //given
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        UIConsole uiConsole = new UIConsole();

        //when
        uiConsole.say(DUMMY_STRING);

        //then
        assertThat(byteArrayOutputStream.toString()).isEqualTo(DUMMY_STRING);
    }


}
