package com.afornalik.ox.board;

class BoardField {

    private FieldStatus fieldStatus;

    FieldStatus showStatus() {
        return fieldStatus;
    }

    void initializeEmptyStatus() {
        fieldStatus = FieldStatus.EMPTY;
    }

    void changeStatus(FieldStatus newFieldStatus) {
        fieldStatus = newFieldStatus;
    }
}
