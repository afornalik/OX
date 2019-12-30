package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.view.UISimple;

class BoardController {

    private final UISimple ui;

    BoardController(UISimple ui) {
        this.ui = ui;
    }

    Board createBoard(){

        ui.print("Select board size :");
        return new Board(ui.readNumber());
    }
}
