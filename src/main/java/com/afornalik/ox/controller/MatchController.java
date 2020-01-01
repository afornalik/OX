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

    private boolean playerMove(String s, Field x) {
        uiExtended.drawBoard();
        if (board.isAllFieldTaken()) {
            return true;
        }
        uiExtended.print(s);
        return doMove(x);
    }

    boolean doMove(Field field) {
        int index;
        try {
            index = getIndex();
            board.insertBoardField(index - 1, field);
            if (boardChecker.check(index - 1, field)) {
                uiExtended.drawBoard();
                uiExtended.print("Winner is  : " + field);
                return true;
            }
        } catch (OutOfBoardException e) {
            uiExtended.print(e.getMessage());
        }
        return false;
    }

    private int getIndex() throws OutOfBoardException {
        int index;
        Field checkStatus;
        do {
            index = uiExtended.readNumber();
            checkStatus = board.receiveBoardField(index - 1);
            if (checkStatus != Field.EMPTY) {
                uiExtended.print("\nField already taken choose different number ");
            }
        } while (checkStatus != Field.EMPTY);
        return index;
    }
}
