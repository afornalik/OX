package com.afornalik.ox.board;

import java.util.Objects;

class BoardField {

    private final FieldStatus fieldStatus;

    BoardField(FieldStatus fieldStatus) {
        this.fieldStatus = fieldStatus;
    }

    FieldStatus showStatus() {
        return fieldStatus;
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
