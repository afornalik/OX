package com.afornalik.ox.ui;

public class UI {


    private final UIConsole uiConsole;
    private final UIDrawBoard uiDrawBoard;

    public UI(UIConsole uiConsole, UIDrawBoard uiDrawBoard) {
        this.uiConsole = uiConsole;
        this.uiDrawBoard = uiDrawBoard;
    }

    public void say() {
        uiConsole.say(uiDrawBoard.draw());
    }
}
