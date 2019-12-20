package com.afornalik.ox.ui;

import com.afornalik.ox.board.OutOfBoardException;

public class UI {

    private final UIOutputDestination uiOutputDestination;
    private final UIDrawBoard uiDrawBoard;

    public UI(UIOutputDestination uiOutputDestination, UIDrawBoard uiDrawBoard) {
        this.uiOutputDestination = uiOutputDestination;
        this.uiDrawBoard = uiDrawBoard;
    }

    public void printBoard() {
        try {
            uiOutputDestination.print(uiDrawBoard.draw());
        } catch (OutOfBoardException e) {
            e.printStackTrace();
        }
    }

    public int readNumber() {
        UIInput uiInput = (UIInput) uiOutputDestination;
        String parseNumber = uiInput.read();
        int parsed = 0;
        try {
            parsed =  Integer.parseInt(parseNumber);
        }catch (NumberFormatException e){
            uiOutputDestination.print("\n Insert number ");
        }
        return parsed;
    }
}
