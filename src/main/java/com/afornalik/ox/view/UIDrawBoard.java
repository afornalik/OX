package com.afornalik.ox.view;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.model.board.FieldStatus;
import com.afornalik.ox.model.board.OutOfBoardException;

import java.math.BigInteger;

public class UIDrawBoard {

    private final Board board;
    private final BigInteger boardDimension;

    public UIDrawBoard(Board board) {
        this.board = board;
        this.boardDimension = new BigInteger(String.valueOf(board.getBorderSize()))
                .multiply(BigInteger.TWO).add(BigInteger.ONE);
    }

    String draw() throws OutOfBoardException {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("\n  ");
        for (int i = 1; i < boardDimension.intValue(); i++) {
            if (i % 2 == 0) sb.append((i / 2));
            else if (i < 19) sb.append(" ");
        }
        sb.append("\n");
        for (int i = 1; i <= board.getBorderSize(); i++) {
            if (i < 10) sb.append(i).append(" ");
            else sb.append(i);
            index = returnGrid(index, sb);
            sb.append("\n");
        }
        return sb.toString();
    }

    private int returnGrid(int index, StringBuilder sb) throws OutOfBoardException {
        for (int k = 0; k < boardDimension.intValue(); k++) {
            if (k % 2 == 0) {
                sb.append("|");
            } else {
                FieldStatus fieldStatus = board.receiveBoardField(index);
                index++;
                sb.append(fieldStatus);
            }
        }
        return index;
    }


}