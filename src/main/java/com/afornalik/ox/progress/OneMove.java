package com.afornalik.ox.progress;

import com.afornalik.ox.board.*;

public class OneMove {


    private final Board board;


    public OneMove(Board board) {
        this.board = board;
    }

    public void makeMove(int indexOfField, FieldStatus fieldStatusX) throws OutOfBoardException, ChangeFieldStatusException {
        BoardField boardField = board.receiveBoardField(indexOfField);
        boardField.changeStatus(fieldStatusX);
    }
}
