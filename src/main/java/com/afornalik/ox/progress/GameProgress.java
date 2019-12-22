package com.afornalik.ox.progress;

import com.afornalik.ox.board.Board;
import com.afornalik.ox.board.FieldStatus;
import com.afornalik.ox.ui.UI;

public class GameProgress {

    private final UI ui;

    public GameProgress(UI ui) {
        this.ui = ui;
    }

    public void oneTurn(Board board) {
        if (onePlayerMove(board, FieldStatus.X)) return;
        if (onePlayerMove(board, FieldStatus.O)) return;
        oneTurn(board);
    }

    private boolean onePlayerMove(Board board, FieldStatus fieldStatus) {
        ui.printBoard();
        OneMove oMove = new OneMove(board);
        if (board.receiveNumberOfEmptyFields() == 0) {
            return true;
        }
        oMove.makeMove(ui.readNumber(), fieldStatus);
        return false;
    }
}
