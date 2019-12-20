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
            e.printStackTrace();
        }
    }

    public int readNumber() {
        String parseNumber = uiOperations.read();
        int parsed = -1;
        do {
            try {
                parsed = Integer.parseInt(parseNumber);
            } catch (NumberFormatException e) {
                uiOperations.print("\n Insert number ");
            }
        }while (parsed==-1);
        return parsed;
    }
}
