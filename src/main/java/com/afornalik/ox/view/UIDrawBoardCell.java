package com.afornalik.ox.view;

import com.afornalik.ox.Board;
import com.afornalik.ox.Field;
import com.afornalik.ox.OutOfBoardException;

import java.util.Formatter;

/**
 * Class responsible for print board on console.
 * board have cell numeration.
 *
 * @author Andrzej Fornalik
 */

public class UIDrawBoardCell implements UIDrawBoard {

    private final Board board;
    private final int boardSize;

    /**
     * Constructor with parameter board.
     * This constructor also calculate boardSize variable.
     *
     * @param board Board This parameter represent board in OX game
     */
    public UIDrawBoardCell(Board board) {
        this.board = board;
        this.boardSize = board.getBorderSize() * board.getBorderSize();
    }

    /**
     * Method construct String representing board.
     * Method use StringBuilder to construct this string, exception OutOfBoardException is caught.
     *
     * @return String String representation of the board
     */

    @Override
    public String drawBoard() {
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < boardSize; index++) {
            if (index % board.getBorderSize() == 0) {
                sb.append("\n|");
            }
            Formatter formatter = new Formatter();
            Field field = Field.EMPTY;
            try {
                field = board.receiveField(index);
            } catch (OutOfBoardException e) {
                return e.getMessage();
            }
            if (field != Field.EMPTY) {
                formatter.format("%2s |", field.toString());
            } else {
                formatter.format("%3s|", index + 1);
            }
            sb.append(formatter.toString());
        }
        return sb.append("\n").toString();
    }

}
