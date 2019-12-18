package com.afornalik.ox.ui;

import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

@Test
public class TestUI  {


    //not completed -> need to know how to check output method

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeMethod
    public void init()
    {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    public void shouldPrintGreetingsToUser() {
        //given
        UI ui = new UI();

        //when
        ui.sayHello();

        //then
        assertEquals(byteArrayOutputStream.toString() , "Welcome to game OX\n");
    }

}
