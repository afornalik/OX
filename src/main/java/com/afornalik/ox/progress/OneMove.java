package com.afornalik.ox.progress;

import com.afornalik.ox.board.*;

public class OneMove {

    private final Board board;

    public OneMove(Board board) {
        this.board = board;
    }

    public void makeMove(int indexOfField, FieldStatus fieldStatusX) {
        board.insertMark(indexOfField,fieldStatusX);
    }
}
