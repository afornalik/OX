package com.afornalik.ox.ui;

import com.afornalik.ox.board.OutOfBoardException;

public class UI {

    private final UIOperations uiOperations;
    private final UIDrawBoard uiDrawBoard;

    public UI(UIOperations uiOperations, UIDrawBoard uiDrawBoard) {
        this.uiOperations = uiOperations;
        this.uiDrawBoard = uiDrawBoard;
    }

    public void printBoard() {
        try {
            uiOperations.print(uiDrawBoard.draw());
        } catch (OutOfBoardException e) {
           uiOperations.print(e.getMessage());
        }
    }

    public int readNumber() {
        return uiOperations.readNumber();
    }

}
