package com.afornalik.ox.board;

public class CheckHorizontally implements CheckBoard {

    public final Board board;
    public final int conditionLength;

    public CheckHorizontally(Board board, int conditionLength) {
        this.board = board;
        this.conditionLength = conditionLength;
    }

    @Override
    public boolean check() {
        return false;
    }
}
