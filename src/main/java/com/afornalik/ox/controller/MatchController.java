package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.*;
import com.afornalik.ox.model.player.Player;
import com.afornalik.ox.model.player.PlayerContainer;
import com.afornalik.ox.view.UIExtended;

class MatchController {

    private final UIExtended uiExtended;
    private final Board board;
    private final PlayerContainer playerContainer;
    private BoardChecker boardChecker;

    MatchController(UIExtended uiExtended, Board board, PlayerContainer playerContainer) {
        this.uiExtended = uiExtended;
        this.board = board;
        this.playerContainer = playerContainer;
        boardChecker = new CheckHorizontally(board);
    }

    Board doTurn() {
        Player first = playerContainer.isFirst();
        Player last = playerContainer.isLast();
        if (playerMove(first.getName() + " move : ", first.getSign())) return board;
        if (playerMove(last.getName() + " move : ", last.getSign())) return board;
        return doTurn();
    }

    private boolean playerMove(String s, FieldStatus x) {
        uiExtended.drawBoard();
        if (board.isAllFieldTaken()) {
            return true;
        }
        uiExtended.print(s);
        return doMove(x);
    }

    boolean doMove(FieldStatus fieldStatus) {
        int index;
        try {
            index = getIndex();
            board.insertBoardField(index - 1, fieldStatus);
            if (boardChecker.check(index - 1, fieldStatus)) {
                uiExtended.drawBoard();
                uiExtended.print("Winner is  : " + fieldStatus);
                return true;
            }
        } catch (OutOfBoardException e) {
            uiExtended.print(e.getMessage());
        }
        return false;
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
}
