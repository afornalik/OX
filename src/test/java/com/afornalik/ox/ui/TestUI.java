package com.afornalik.ox.ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

@Test
public class TestUI  {

    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    @BeforeMethod
    public void init()
    {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    public void shouldPrintGreetingToUser() {
        //given
        UI ui = new UI();

        //when
        ui.sayHello();

        //then
        assertEquals(byteArrayOutputStream.toString() , "Welcome to game OX");
    }

}
