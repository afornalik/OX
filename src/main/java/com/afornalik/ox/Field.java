package com.afornalik.ox;

public enum Field {
    EMPTY("_"),
    X("X"),
    O("O");

    final String value;

    Field(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
