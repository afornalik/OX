package com.afornalik.ox.progress;

import com.afornalik.ox.board.*;

class OneMove {

    private final Board board;

    OneMove(Board board) {
        this.board = board;
    }

    void makeMove(int indexOfField, FieldStatus fieldStatusX) {
        try {
            board.insertBoardField(indexOfField, fieldStatusX);
        } catch (OutOfBoardException e) {
            System.out.println(e.getMessage());
        }
    }
}
