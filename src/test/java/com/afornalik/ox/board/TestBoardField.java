package com.afornalik.ox.board;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class TestBoardField {

    private static final FieldStatus FIELD_STATUS_EMPTY = FieldStatus.EMPTY;
    private static final FieldStatus FIELD_STATUS_X = FieldStatus.X;
    private static final FieldStatus FIELD_STATUS_O = FieldStatus.O;


    public void shouldCreateFieldWithEmptyValue() {
        //when
        BoardField boardField = new BoardField();

        //then
        assertEquals(boardField.showStatus(),FIELD_STATUS_EMPTY);
    }

    public void shouldSetUpFieldValueToXAfterInitialization() {
        //given
        BoardField boardField = new BoardField();

        //then
        boardField.changeStatus(FIELD_STATUS_X);

        //then
        assertEquals(boardField.showStatus(),FIELD_STATUS_X);
    }

    public void shouldSetUpFieldValueToOAfterInitialization() {
        //given
        BoardField boardField = new BoardField();

        //then
        boardField.changeStatus(FIELD_STATUS_O);

        //then
        assertEquals(boardField.showStatus(),FIELD_STATUS_O);
    }

}