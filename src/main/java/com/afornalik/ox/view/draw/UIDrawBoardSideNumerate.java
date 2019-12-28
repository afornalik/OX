package com.afornalik.ox.view.draw;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.model.board.FieldStatus;
import com.afornalik.ox.model.board.OutOfBoardException;

import java.math.BigInteger;

/**
 * Class responsible for print board on console.
 * board have two side numerated but, cell in grid are empty.
 *
 * @author Andrzej Fornalik
 */

public class UIDrawBoardSideNumerate implements UIDrawBoard {

    private Board board;
    private BigInteger boardDimension;

    /**
     * Constructor with parameter board.
     * This constructor also calculate boardDimension variable.
     *
     * @param board Board This parameter represent board in OX game
     */

    public UIDrawBoardSideNumerate(Board board) {
        this.board = board;
        this.boardDimension = new BigInteger(String.valueOf(board.getBorderSize()))
                .multiply(BigInteger.TWO).add(BigInteger.ONE);
    }

    /**
     * Method construct String representing board.
     * Method use StringBuilder to construct this string, exception OutOfBoardException is caught.
     *
     * @return String String representation of the board
     */

    public String drawBoard()  {
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

    private int returnGrid(int index, StringBuilder sb)  {
        for (int k = 0; k < boardDimension.intValue(); k++) {
            if (k % 2 == 0) {
                sb.append("|");
            } else {
                FieldStatus fieldStatus = null;
                try {
                    fieldStatus = board.receiveBoardField(index);
                } catch (OutOfBoardException e) {
                    //to do
                }
                index++;
                sb.append(fieldStatus);
            }
        }
        return index;
    }

    /**
     * Method construct String representing board.
     * Method use StringBuilder to construct this string, exception OutOfBoardException is caught.
     *
     * @param board Board This parameter determine board to be draw
     * @return String String representation of the board
     */
    @Override
    public String drawBoard(Board board) {
        this.board = board;
        this.boardDimension = new BigInteger(String.valueOf(board.getBorderSize()))
                .multiply(BigInteger.TWO).add(BigInteger.ONE);
        return this.drawBoard();
    }

}