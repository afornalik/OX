package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.view.UIOperations;

class BoardController {

    private final UIOperations uiOperations;

    BoardController(UIOperations uiOperations) {
        this.uiOperations = uiOperations;
    }

    Board createBoard(){

        uiOperations.print("Select board size :");
        return new Board(uiOperations.readNumber());
    }
}
