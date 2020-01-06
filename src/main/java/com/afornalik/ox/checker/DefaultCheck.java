package com.afornalik.ox.checker;

import com.afornalik.ox.Board;
import com.afornalik.ox.Field;

import java.util.ArrayList;
import java.util.List;

public class DefaultCheck {

    private final List<BoardChecker> boardCheckers = new ArrayList<>();

    public DefaultCheck(Board board) {
        boardCheckers.add(new CheckDiagonallyLeft(board));
        boardCheckers.add(new CheckDiagonallyRight(board));
        boardCheckers.add(new CheckHorizontally(board));
        boardCheckers.add(new CheckVertically(board));
    }

    public boolean checkBoard(int location, Field field) {
        return boardCheckers.stream().anyMatch(boardChecker -> boardChecker.check(location,field));
    }
}
