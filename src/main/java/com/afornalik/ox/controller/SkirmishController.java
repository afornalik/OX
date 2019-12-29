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

    Board makeMove(FieldStatus fieldStatus) {

        try {
            board.insertBoardField((uiConsole.readNumber()-1), fieldStatus);
        } catch (OutOfBoardException e) {
            uiConsole.print(e.getMessage());
        }
        return board;
    }

    Board makeTurn() {
        uiConsole.drawBoard();
        uiConsole.print("Player 1 move : ");
        makeMove(FieldStatus.X);
        uiConsole.drawBoard();
        uiConsole.print("Player 1 move : ");
        makeMove(FieldStatus.O);
        return board;
    }
}
