package com.afornalik.ox.board;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class TestBoardField {

    public void shouldCreateField() {
        //when
        BoardField boardField = new BoardField();

        //then
        assertNotNull(boardField);
    }


}
