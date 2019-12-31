package com.afornalik.ox.view;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.view.draw.UIDrawBoard;
import com.afornalik.ox.view.draw.UIDrawBoardCellNumerate;
import com.afornalik.ox.view.draw.UIDrawBoardSideNumerate;
import com.afornalik.ox.view.print.UIOperations;

public class UIExtended extends UISimple {

    private final UIDrawBoard uiDrawBoard;

    public UIExtended(UIOperations uiOperations, DrawBoardType drawBoardType, Board board) {
        super(uiOperations);
        if (drawBoardType == DrawBoardType.CELL) {
            uiDrawBoard = new UIDrawBoardCellNumerate(board);
        } else {
            uiDrawBoard = new UIDrawBoardSideNumerate(board);
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
