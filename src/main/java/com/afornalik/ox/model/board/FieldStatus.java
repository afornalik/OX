package com.afornalik.ox.model.board;

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