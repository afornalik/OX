package com.afornalik.ox.board;

class MoveConvert {
    private int boardSize;

    public MoveConvert(int boardSize) {
        this.boardSize = boardSize;
    }

    public int convertToIndex(int axisX, int axisY) {
        return  ((axisY-1)*boardSize)+(axisX-1);
    }
}
