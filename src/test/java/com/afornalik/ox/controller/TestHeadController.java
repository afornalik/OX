package com.afornalik.ox.controller;

import com.afornalik.ox.view.UIConsole;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Test
public class TestHeadController {

     public void shouldGreetUser(){
         //given
         UIConsole uiConsole = Mockito.mock(UIConsole.class);
         HeadController headController = new HeadController(uiConsole);

         //when
         headController.greetUser();

         //then
         verify(uiConsole,times(1)).print(any());
     }
}
