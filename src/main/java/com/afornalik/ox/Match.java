package com.afornalik.ox;

import com.afornalik.ox.view.UI;
import com.afornalik.ox.view.UIDrawBoard;
import com.afornalik.ox.view.UIDrawBoardCell;

import java.util.ArrayList;
import java.util.List;

class Match {

    private UIDrawBoard uiDrawBoard;
    private final UI ui;
    private final Board board;
    private final List<Integer> argsIndex;
    private final List<Player> players;
    private BoardChecker boardChecker;

    Match(UI ui, Board board, List<Player> players, List<Integer> argsIndex) {
        this.ui = ui;
        this.board = board;
        this.players = players;
        boardChecker = new CheckHorizontally(board);
        uiDrawBoard = new UIDrawBoardCell(board);
        if (argsIndex == null) {
            this.argsIndex = new ArrayList<>();
            this.argsIndex.add(0);
        } else {
            this.argsIndex = argsIndex;
        }
    }

    Board nextRound(Integer index) {
        if (returnBoard(players.get(0), index) || returnBoard(players.get(1), index)) {
            return board;
        }
        return nextRound(index);
    }

    private boolean returnBoard(Player player, Integer index) {
        if (playerMove(player.getName() + " move : ", player.getSign(), argsIndex.get(index)))
            if (index >= argsIndex.size() - 1) {
                if (index == argsIndex.size() - 1 || argsIndex.get(0) != 0) {
                    //ui.print("\nMatch draw");
                    return true;
                }
            }
        return false;
    }

    private boolean playerMove(String s, Field field, int index2) {
        ui.print(uiDrawBoard.drawBoard());
        ui.print(s);
        int index;
        if (board.isAllFieldTaken()) {
            return true;
        }
        try {
            index = receiveIndex(index2);
            board.insertField(index - 1, field);
            if (boardChecker.check(index - 1, field)) {
                ui.print(uiDrawBoard.drawBoard());
                ui.print("Winner is  : " + field);
                return true;
            }
        } catch (OutOfBoardException e) {
            ui.print(e.getMessage());
        }
        return false;
    }


    private int receiveIndex(int argsIndex) throws OutOfBoardException {
        int index;
        Field checkStatus;
        do {
            if (argsIndex != 0) {
                index = argsIndex;
                ui.print(index + "\n");
            } else {
                index = ui.readNumber();
            }
            checkStatus = board.receiveField(index - 1);
            if (checkStatus != Field.EMPTY) {
                ui.print("\nField already taken choose different number ");
            }
        } while (checkStatus != Field.EMPTY);
        return index;
    }
}
