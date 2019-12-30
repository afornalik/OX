package com.afornalik.ox.controller;

import com.afornalik.ox.view.UISimple;
import com.afornalik.ox.view.print.UIConsoleOperations;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Test
public class TestHeadController {

     public void shouldGreetUser(){
         //given
         UISimple uiSimple = Mockito.mock(UISimple.class);
         HeadController headController = new HeadController(uiSimple);

         //when
         headController.greetUser();

         //then
         verify(uiSimple,times(1)).print(any());
     }
}
