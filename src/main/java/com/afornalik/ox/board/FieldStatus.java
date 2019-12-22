package com.afornalik.ox.board;

public enum FieldStatus {
    EMPTY("_"),
    X("X"),
    O("O");

    final String value;

    FieldStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
