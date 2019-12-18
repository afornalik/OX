package com.afornalik.ox.board;

class BoardField {

    FieldStatus fieldStatus;

    FieldStatus showStatus() {
        return fieldStatus;
    }

    void initializeEmptyStatus() {
        fieldStatus = FieldStatus.EMPTY;
    }

    public void changeStatus(FieldStatus newFieldStatus) {
        fieldStatus = newFieldStatus;
    }
}
