package com.afornalik.ox.board;

class BoardField {

    private FieldStatus fieldStatus;

    BoardField() {
        this.fieldStatus = FieldStatus.EMPTY;
    }

    FieldStatus showStatus() {
        return fieldStatus;
    }

    void changeStatus(FieldStatus newFieldStatus) {
        this.fieldStatus = newFieldStatus;
    }
}
