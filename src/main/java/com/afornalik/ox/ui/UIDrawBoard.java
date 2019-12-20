package com.afornalik.ox.ui;

import com.afornalik.ox.board.Board;

import java.math.BigInteger;

public class UIDrawBoard {

    private final Board board;
    private final BigInteger boardDimension;

    public UIDrawBoard(Board board) {
        this.board = board;
        this.boardDimension = new BigInteger(String.valueOf(board.getBound()))
                .multiply(BigInteger.TWO).add(BigInteger.ONE);

    }


    String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n  ");
        for (int i = 1; i < boardDimension.intValue(); i++) {
            if (i % 2 == 0) sb.append((i / 2));
            else if (i < 19) sb.append(" ");
        }
        sb.append("\n");
        for (int i = 1; i <= board.getBound(); i++) {
            if (i < 10) sb.append(i).append(" ");
            else sb.append(i);
            for (int k = 0; k < boardDimension.intValue(); k++) {
                if (k % 2 == 0) sb.append("|");
                else sb.append("_");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
