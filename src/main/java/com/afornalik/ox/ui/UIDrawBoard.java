package com.afornalik.ox.ui;

import com.afornalik.ox.board.Board;

public class UIDrawBoard {

    private final Board board;

    public UIDrawBoard(Board board) {
        this.board = board;
    }

    String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n  ");
        for (int i = 1; i < (board.getBound() * 2) + 1; i++) {
            if (i % 2 == 0) sb.append((i / 2));
            else if (i < 19) sb.append(" ");
        }
        sb.append("\n");
        for (int i = 1; i <= board.getBound(); i++) {
            if (i < 10) sb.append(i).append(" ");
            else sb.append(i);
            for (int k = 0; k < (board.getBound() * 2) + 1; k++) {
                if (k % 2 == 0) sb.append("|");
                else sb.append("_");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
