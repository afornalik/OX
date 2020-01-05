package com.afornalik.ox.view;

import org.assertj.core.api.Assertions;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.Scanner;

import static org.mockito.Mockito.when;

@Test
public class TestUIConsole {

    private static final String NUMBER_VALUE = "42";
    private static final String DUMMY_STRING = "Some dummy string to print";

    public void shouldReceiveConsoleInputFromUser() {
        //given
        Scanner scanner = Mockito.mock(Scanner.class);
        Mockito.when(scanner.next()).thenReturn(DUMMY_STRING);
        UI uiConsole = new UI(scanner);

        //when
        String result = uiConsole.read();

        //then
        Assertions.assertThat(result).isEqualTo(DUMMY_STRING);

    }

    public void shouldReadNumberFromUser() {
        //given
        Scanner scanner = Mockito.mock(Scanner.class);
        when(scanner.next()).thenReturn(NUMBER_VALUE);
        UI uiInput = new UI(scanner);

        //when
        int result = uiInput.readNumber();

        //then
        Assertions.assertThat(result).isEqualTo(Integer.parseInt(NUMBER_VALUE));
    }


}
