package com.afornalik.ox;

/**
 * Represent state of cell in the board.
 */
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
