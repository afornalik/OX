package com.afornalik.ox.progress;

import com.afornalik.ox.board.Board;
import com.afornalik.ox.board.FieldStatus;
import com.afornalik.ox.board.OutOfBoardException;
import com.afornalik.ox.board.OverrideFieldException;
import com.afornalik.ox.ui.UI;

public class GameProgress {

    private final UI ui;

    public GameProgress(UI ui) {
        this.ui = ui;
    }

    public void oneTurn(Board board) {
        if (onePlayerMove(board, FieldStatus.X)) return;
        if (onePlayerMove(board, FieldStatus.O)) return;
        oneTurn(board);
    }

    private boolean onePlayerMove(Board board, FieldStatus fieldStatus) {
        ui.printBoard();
        if (board.receiveNumberOfEmptyFields() == 0) {
            return true;
        }
        boolean flag = false;
        do {
            try {
                System.out.println(fieldStatus+" move");
                System.out.print("Insert horizontal coordinate :");
                int horizontal = ui.readNumber();
                System.out.print("Insert vertical coordinate :");
                int vertical = ui.readNumber();
                board.insertBoardField(horizontal,vertical, fieldStatus);
                flag = true;
            } catch (OverrideFieldException | OutOfBoardException e) {
                //to change in future into ui.print
                System.out.println(e.getMessage());
                ui.printBoard();
            }
        }while (!flag) ;
        return false;
    }
}
