package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.model.board.FieldStatus;
import com.afornalik.ox.model.board.OutOfBoardException;
import com.afornalik.ox.model.player.PlayerContainer;
import com.afornalik.ox.view.UIConsole;
import com.afornalik.ox.view.UIOperations;

class SkirmishController {

    private final UIOperations uiConsole;
    private final Board board;
    private final PlayerContainer playerContainer;

    SkirmishController(UIOperations uiConsole, Board board, PlayerContainer playerContainer) {
        this.uiConsole = uiConsole;
        this.board = board;
        this.playerContainer = playerContainer;
    }

    Board makeMove() {

        uiConsole.print("Make a move :");
        try {
            board.insertBoardField((uiConsole.readNumber()-1), FieldStatus.X);
        } catch (OutOfBoardException e) {
            uiConsole.print(e.getMessage());
        }
        return board;
    }
}
