package com.afornalik.ox.progress;

import com.afornalik.ox.board.Board;
import com.afornalik.ox.ui.UI;

public class GameProgress {

    private final UI ui;
    private final Board board;

    public GameProgress(UI ui, Board board) {
        this.ui = ui;
        this.board = board;
    }

    public void start() {
        ui.printBoard();
    }
}
