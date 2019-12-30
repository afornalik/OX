package com.afornalik.ox.view.draw;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.model.board.FieldStatus;
import com.afornalik.ox.model.board.OutOfBoardException;

import java.util.Formatter;

/**
 * Class responsible for print board on console.
 * board have cell numeration.
 *
 * @author Andrzej Fornalik
 */

public class UIDrawBoardCellNumerate implements UIDrawBoard {

    private final Board board;
    private final int boardDimension;

    /**
     * Constructor with parameter board.
     * This constructor also calculate boardDimension variable.
     *
     * @param board Board This parameter represent board in OX game
     */
    public UIDrawBoardCellNumerate(Board board) {
        this.board = board;
        this.boardDimension = board.getBorderSize() * board.getBorderSize();
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
        for (int index = 0; index < boardDimension; index++) {
            if (index % board.getBorderSize() == 0) {
                sb.append("\n|");
            }
            Formatter formatter = new Formatter();
            FieldStatus fieldStatus = FieldStatus.EMPTY;
            try {
                fieldStatus = board.receiveBoardField(index);
            } catch (OutOfBoardException e) {
                //to do
            }
            if (fieldStatus != FieldStatus.EMPTY) {
                formatter.format("%2s |", fieldStatus.toString());
            } else {
                formatter.format("%3s|", index + 1);
            }
            sb.append(formatter.toString());
        }
        return sb.append("\n").toString();
    }

    /**
     * NOT COMPLETED
     * Method construct String representing board.
     * Method use StringBuilder to construct this string.
     *
     * @param board Board This parameter determine board to be draw
     * @return String String representation of the board
     */
    @Override
    public String drawBoard(Board board) {
        return null;
    }
}
