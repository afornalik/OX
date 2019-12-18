package com.afornalik.ox.board;

import java.util.Map;

public class Board {

    private Map<Integer,BoardField> boardFields;
    private final int bound;

    public Board(int bound) {
        this.bound = bound;
    }

    public int getBound() {
        return bound;
    }

    boolean initializeAllField(Map<Integer,BoardField> mapImplementation) {
        int fieldQuantity = bound * bound;
        boardFields = mapImplementation;
        for (int i = 0; i < fieldQuantity; i++){
            boardFields.put(i,new BoardField());
        }
        return true;
    }

    BoardField receiveBoardField(int i) {
        return boardFields.get(1);
    }
}
