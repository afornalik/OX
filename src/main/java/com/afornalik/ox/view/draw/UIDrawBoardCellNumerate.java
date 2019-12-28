package com.afornalik.ox.view.draw;

import com.afornalik.ox.model.board.Board;

import java.math.BigInteger;

public class UIDrawBoardCellNumerate implements UIDrawBoard {

    private final Board board;
    private final BigInteger boardDimension;

    public UIDrawBoardCellNumerate(Board board) {
        this.board = board;
        this.boardDimension = new BigInteger(String.valueOf(board.getBorderSize()))
                .multiply(BigInteger.TWO).add(BigInteger.ONE);
    }


    @Override
    public String drawBoard() {
        return null;
    }

    @Override
    public String drawBoard(Board board) {
        return null;
    }
}
