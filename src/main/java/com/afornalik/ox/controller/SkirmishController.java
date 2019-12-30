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
        int index;
        try {
            FieldStatus checkStatus = FieldStatus.EMPTY;
            do {
                index = uiConsole.readNumber();
                try {
                    checkStatus = board.receiveBoardField(index - 1);
                } catch (OutOfBoardException e2) {
                   // uiConsole.print(e2.getMessage());
                }
                if (checkStatus != FieldStatus.EMPTY){
                    uiConsole.print("\nField already taken choose different number ");
                }
            } while (checkStatus != FieldStatus.EMPTY);
            board.insertBoardField(index - 1, fieldStatus);
        } catch (OutOfBoardException e) {
            uiConsole.print(e.getMessage());
        }
        return board;
    }

    Board makeTurn() {
        uiConsole.drawBoard();
        if (board.receiveNumberOfEmptyFields() == 0) {
            return board;
        }
        uiConsole.print("Player 1 move : ");
        makeMove(FieldStatus.X);
        uiConsole.drawBoard();
        if (board.receiveNumberOfEmptyFields() == 0) {
            return board;
        }
        uiConsole.print("Player 2 move : ");
        makeMove(FieldStatus.O);
        return makeTurn();
    }
}
