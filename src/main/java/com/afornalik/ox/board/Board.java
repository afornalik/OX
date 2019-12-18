package com.afornalik.ox.board;

public class Board {


    private final int bound;

    public Board(int bound) {
        this.bound = bound;
    }

    public int getBound() {
        return bound;
    }

    boolean initializeAllField() {
        return true;
    }
}
