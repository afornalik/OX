package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.model.player.PlayerContainer;
import com.afornalik.ox.view.UIConsole;
import com.afornalik.ox.view.UIOperations;
import com.afornalik.ox.view.draw.UIDrawBoardCellNumerate;

import java.util.Scanner;

class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UIOperations uiOperations = new UIConsole(scanner);
        HeadController headController = new HeadController(uiOperations);
        PlayerController playerController = new PlayerController(uiOperations);
        BoardController boardController = new BoardController(uiOperations);
        headController.greetUser();
        playerController.createPlayer();
        Board board = boardController.createBoard();

        uiOperations = new UIConsole(new UIDrawBoardCellNumerate(board),scanner);
        SkirmishController skirmishController = new SkirmishController(uiOperations,board,new PlayerContainer());
        skirmishController.makeTurn();


    }
}
