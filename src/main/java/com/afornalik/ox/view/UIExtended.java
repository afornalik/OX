package com.afornalik.ox.view;

import com.afornalik.ox.Board;

import java.util.Scanner;

public class UIExtended extends UISimple {

    private final UIDrawBoard uiDrawBoard;

    public UIExtended(Scanner scanner,DrawBoardType drawBoardType, Board board) {
        super(scanner);
        if (drawBoardType == DrawBoardType.CELL) {
            uiDrawBoard = new UIDrawBoardCell(board);
        } else {
            uiDrawBoard = new UIDrawBoardSide(board);
        }
    }

    public void drawBoard() {
        super.print(uiDrawBoard.drawBoard());
    }


    @Override
    public void print(String string) {
        super.print(string);
    }

    @Override
    public int readNumber() {
        return super.readNumber();
    }

    @Override
    public String read() {
        return super.read();
    }
}
