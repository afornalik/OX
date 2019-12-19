package com.afornalik.ox.board;

class BoardField {

    private FieldStatus fieldStatus;

    BoardField() {
        this.fieldStatus = FieldStatus.EMPTY;
    }

    FieldStatus showStatus() {
        return fieldStatus;
    }

    void changeStatus(FieldStatus newFieldStatus) throws ChangeFieldStatusException {
        if (fieldStatus != FieldStatus.EMPTY) {
            throw new ChangeFieldStatusException();
        }else {
            this.fieldStatus = newFieldStatus;
        }
    }
}
