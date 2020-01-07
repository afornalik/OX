package com.afornalik.ox;

import com.afornalik.ox.checker.DefaultCheck;
import com.afornalik.ox.view.UI;
import com.afornalik.ox.view.UIDrawBoard;
import com.afornalik.ox.view.UIDrawBoardCell;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

class Match {

    private final UIDrawBoard uiDrawBoard;
    private final UI ui;
    private final Board board;
    private final List<Player> players;
    private final DefaultCheck defaultCheck;
    private final Logger logger = LogManager.getLogger(Match.class);

    Match(UI ui, Board board, List<Player> players) {
        this.ui = ui;
        this.board = board;
        this.players = players;
        defaultCheck = new DefaultCheck(board);
        uiDrawBoard = new UIDrawBoardCell(board);
    }

    Board nextRound() {
        if (checkIfLastMove(players.get(0)) ) {
            return board;
        }
        if (checkIfLastMove(players.get(1)) ) {
            return board;
        }
        return nextRound();
    }

    private boolean checkIfLastMove(Player player) {
        return playerMove(player.getName() + " move : ", player.getSign());
    }

    private boolean playerMove(String s, Field field) {
        ui.print(uiDrawBoard.drawBoard());
        ui.print(s);
        int index = 0;
        if (board.isAllFieldTaken()) {
            ui.print("Match draw ");
            return true;
        }
        try {
            index = receiveIndex();
            board.insertField(index - 1, field);
            if (defaultCheck.checkBoard(index - 1, field)) {
                ui.print(uiDrawBoard.drawBoard());
                ui.print("Winner is  : " + field);
                return true;
            }
        } catch (OutOfBoardException e) {
            logger.error(e.getMessage());
            ui.print(e.getMessage());
        }
        return false;
    }


    private int receiveIndex() throws OutOfBoardException {
        int index;
        Field checkStatus;
        do {
            index = ui.readNumber();
            checkStatus = board.receiveField(index - 1);
            if (checkStatus != Field.EMPTY) {
                ui.print("\nField already taken choose different number ");
            }
        } while (checkStatus != Field.EMPTY);
        return index;
    }
}
