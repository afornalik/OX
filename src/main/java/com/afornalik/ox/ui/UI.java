package com.afornalik.ox.ui;

public class UI {

    private final UIOutputDestination uiOutputDestination;
    private final UIDrawBoard uiDrawBoard;

    public UI(UIOutputDestination uiOutputDestination, UIDrawBoard uiDrawBoard) {
        this.uiOutputDestination = uiOutputDestination;
        this.uiDrawBoard = uiDrawBoard;
    }

    public void printBoard() {
        uiOutputDestination.print(uiDrawBoard.draw());
    }
}
