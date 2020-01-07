package com.afornalik.ox.checker;

import com.afornalik.ox.Board;
import com.afornalik.ox.Field;

import java.util.ArrayList;
import java.util.List;

/**
 *  Join four implementation of BoardChecker interface.
 */

public class DefaultCheck {

    private final List<BoardChecker> boardCheckers = new ArrayList<>();

    /**
     * Add four BoardChecker implementation to list
     *
     * @param board Board parameter pass to each BoardChecker implementation
     */
    public DefaultCheck(Board board) {
        boardCheckers.add(new CheckDiagonallyLeft(board));
        boardCheckers.add(new CheckDiagonallyRight(board));
        boardCheckers.add(new CheckHorizontally(board));
        boardCheckers.add(new CheckVertically(board));
    }

    /**
     * Check if the winning condition is fulfilled.
     *
     * @param location  int location of added point to board.
     * @param field     Field type of field (X or O)
     * @return          true if the win condition is fulfilled otherwise false
     */
    public boolean checkBoard(int location, Field field) {
        return boardCheckers.stream().anyMatch(boardChecker -> boardChecker.check(location, field));
    }
}
