package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.model.board.FieldStatus;
import com.afornalik.ox.model.board.OutOfBoardException;
import com.afornalik.ox.model.player.Player;
import com.afornalik.ox.model.player.PlayerContainer;
import com.afornalik.ox.view.UIExtended;

class MatchController {

    private final UIExtended uiExtended;
    private final Board board;
    private final PlayerContainer playerContainer;

    MatchController(UIExtended uiExtended, Board board, PlayerContainer playerContainer) {
        this.uiExtended = uiExtended;
        this.board = board;
        this.playerContainer = playerContainer;
    }

    Board doTurn() {
        Player first = playerContainer.isFirst();
        Player last = playerContainer.isLast();
        if (playerMove(first.getName() + " move : ", first.getSign())) return board;
        if (playerMove(last.getName() + " move : ", last.getSign())) return board;
        return doTurn();
    }

    Board doMove(FieldStatus fieldStatus) {
        int index;
        try {
            index = getIndex();
            board.insertBoardField(index - 1, fieldStatus);
        } catch (OutOfBoardException e) {
            uiExtended.print(e.getMessage());
        }
        return board;
    }

    private int getIndex() throws OutOfBoardException {
        int index;
        FieldStatus checkStatus;
        do {
            index = uiExtended.readNumber();
            checkStatus = board.receiveBoardField(index - 1);
            if (checkStatus != FieldStatus.EMPTY) {
                uiExtended.print("\nField already taken choose different number ");
            }
        } while (checkStatus != FieldStatus.EMPTY);
        return index;
    }

    private boolean playerMove(String s, FieldStatus x) {
        uiExtended.drawBoard();
        if (board.isAllFieldTaken()) {
            return true;
        }
        uiExtended.print(s);
        doMove(x);
        return false;
    }
}
