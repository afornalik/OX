package com.afornalik.ox.board;

import java.util.Objects;

public class BoardField {

    private FieldStatus fieldStatus;

    public BoardField() {
        this.fieldStatus = FieldStatus.EMPTY;
    }

    public FieldStatus showStatus() {
        return fieldStatus;
    }

    public void changeStatus(FieldStatus newFieldStatus) throws ChangeFieldStatusException {
        if (fieldStatus != FieldStatus.EMPTY) {
            throw new ChangeFieldStatusException();
        }else {
            this.fieldStatus = newFieldStatus;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardField that = (BoardField) o;
        return fieldStatus == that.fieldStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldStatus);
    }
}
