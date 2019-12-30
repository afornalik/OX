package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.model.player.PlayerContainer;
import com.afornalik.ox.view.DrawBoardType;
import com.afornalik.ox.view.UIExtended;
import com.afornalik.ox.view.UISimple;
import com.afornalik.ox.view.print.UIConsoleOperations;
import com.afornalik.ox.view.draw.UIDrawBoardCellNumerate;

import java.util.Scanner;

class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UISimple uiSimple = new UISimple(new UIConsoleOperations(scanner));
        HeadController headController = new HeadController(uiSimple);
        PlayerController playerController = new PlayerController(uiSimple);
        BoardController boardController = new BoardController(uiSimple);
        headController.greetUser();
        playerController.createTwoPlayer();
        Board board = boardController.createBoard();

        UIExtended uiExtended = new UIExtended(new UIConsoleOperations(scanner), DrawBoardType.CELL,board);
        MatchController matchController = new MatchController(uiExtended,board,new PlayerContainer());
        matchController.doTurn();


    }
}
