package com.afornalik.ox.board;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class TestBoardField {

    private static final FieldStatus FIELD_STATUS_X = FieldStatus.X;
    private static final FieldStatus FIELD_STATUS_O = FieldStatus.O;



    public void shouldSetUpFieldValueToX() {
        //then
        BoardField boardField = new BoardField(FIELD_STATUS_O.X);

        //then
        assertEquals(boardField.showStatus(),FIELD_STATUS_X);
    }

    public void shouldSetUpFieldValueToO() {
        //then
        BoardField boardField = new BoardField(FIELD_STATUS_O);

        //then
        assertEquals(boardField.showStatus(),FIELD_STATUS_O);
    }

}
