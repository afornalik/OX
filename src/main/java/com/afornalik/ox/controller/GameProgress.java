package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.model.board.FieldStatus;
import com.afornalik.ox.view.UIOperations;

public class GameProgress {

    private final UIOperations ui;

    public GameProgress(UIOperations ui) {
        this.ui = ui;
    }

    public void oneTurn(Board board) {
        if (onePlayerMove(board, FieldStatus.X)) return;
        if (onePlayerMove(board, FieldStatus.O)) return;
        oneTurn(board);
    }

    private boolean onePlayerMove(Board board, FieldStatus fieldStatus) {
        ui.drawBoard();
        OneMove oMove = new OneMove(board);
        if (board.receiveNumberOfEmptyFields() == 0) {
            return true;
        }
        oMove.makeMove(ui.readNumber(), fieldStatus);
        return false;
    }
}
