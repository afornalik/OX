package com.afornalik.ox.view;

import com.afornalik.ox.Board;

import java.util.Scanner;

/**
 * Class extended UISimple class.
 * Add method to draw board. Board need to be passed as a argument in a constructor.
 */
public class UIExtended extends UISimple {

    private final UIDrawBoard uiDrawBoard;

    /**
     *  Default constructor Scanner,DrawBoardType and Board need to be specified.
     *
     * @param scanner object hold input from a user.
     * @param drawBoardType enum type which specify what UIDrawBoard implementation will be use.
     * @param board board object to be draw.
     */

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
