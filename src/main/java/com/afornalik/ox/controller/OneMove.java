package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.model.board.FieldStatus;
import com.afornalik.ox.model.board.OutOfBoardException;


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
