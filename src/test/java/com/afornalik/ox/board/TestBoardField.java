package com.afornalik.ox.board;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class TestBoardField {

    private static final FieldStatus FIELD_STATUS = FieldStatus.EMPTY;

    public void shouldCreateField() {
        //when
        BoardField boardField = new BoardField();

        //then
        assertNotNull(boardField);
    }

    public void shouldCreateFieldWithEmptyValue() {
        //given
        BoardField boardField = new BoardField();

        //when
        boardField.initializeEmptyStatus();

        //then
        assertEquals(boardField.showStatus(),FIELD_STATUS);
    }
}
