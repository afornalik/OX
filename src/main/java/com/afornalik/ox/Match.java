package com.afornalik.ox;

import com.afornalik.ox.view.UIExtended;

import java.util.ArrayList;
import java.util.List;

class Match {

    private final UIExtended uiExtended;
    private final Board board;
    private final PlayerContainer playerContainer;
    private final List<Integer> argsIndex;
    private BoardChecker boardChecker;

    Match(UIExtended uiExtended, Board board, PlayerContainer playerContainer, List<Integer> argsIndex) {
        this.uiExtended = uiExtended;
        this.board = board;
        this.playerContainer = playerContainer;
        boardChecker = new CheckHorizontally(board);
        if (argsIndex == null) {
            this.argsIndex = new ArrayList<>();
            this.argsIndex.add(0);
        } else {
            this.argsIndex = argsIndex;
        }
    }

    Board makeATurn(int index) {
        Player first = playerContainer.isFirst();
        Player last = playerContainer.isLast();
        if (playerMove(first.getName() + " move : ", first.getSign(), argsIndex.get(index))) return board;
        if (index < argsIndex.size() - 1) {
            index++;
        } else if (index == argsIndex.size() - 1 && argsIndex.get(0) != 0) {
            uiExtended.drawBoard();
            return board;
        }
        if (playerMove(last.getName() + " move : ", last.getSign(), argsIndex.get(index))) return board;
        if (index < argsIndex.size() - 1) {
            index++;
        } else if (index == argsIndex.size() - 1 && argsIndex.get(0) != 0) {
            uiExtended.drawBoard();
            return board;
        }
        return makeATurn(index);
    }

    private boolean playerMove(String s, Field x, int index) {
        uiExtended.drawBoard();
        if (board.isAllFieldTaken()) {
            return true;
        }
        uiExtended.print(s);
        return makeAMove(x, index);
    }

    private boolean makeAMove(Field field, int argsIndex) {
        int index;
        try {
            index = receiveIndex(argsIndex);
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

    private int receiveIndex(int argsIndex) throws OutOfBoardException {
        int index;
        Field checkStatus;
        do {
            if (argsIndex != 0) {
                index = argsIndex;
                uiExtended.print(index + "\n");
            } else {
                index = uiExtended.readNumber();
            }
            checkStatus = board.receiveBoardField(index - 1);
            if (checkStatus != Field.EMPTY) {
                uiExtended.print("\nField already taken choose different number ");
            }
        } while (checkStatus != Field.EMPTY);
        return index;
    }
}
