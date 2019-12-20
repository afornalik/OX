package com.afornalik.ox.board;

class BoardField {

    private final FieldStatus fieldStatus;

    BoardField(FieldStatus fieldStatus) {
        this.fieldStatus = fieldStatus;
    }

    FieldStatus showStatus() {
        return fieldStatus;
    }
}
