package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.view.UIConsole;
import com.afornalik.ox.view.UIOperations;
import com.afornalik.ox.view.draw.UIDrawBoardCellNumerate;

import java.util.InputMismatchException;
import java.util.Scanner;

class MainApp {

    public static void main(String[] args) {
  /*      System.out.println("Welcome");
        System.out.println("give board range (prefer from 0 to 50) : ");
        Board board;
        try {
            board = new Board(new Scanner(System.in).nextInt());
        } catch (InputMismatchException e) {
            System.out.println("range set to 3");
            board = new Board(3);
        }
        UIOperations ui = new UIConsole(new UIDrawBoardCellNumerate(board),new Scanner(System.in));
      //  GameProgress gameProgress = new GameProgress(ui);

       // gameProgress.oneTurn(board);*/
        Scanner scanner = new Scanner(System.in);
        UIOperations uiOperations = new UIConsole(scanner);
        HeadController headController = new HeadController(uiOperations);
        PlayerController playerController = new PlayerController(uiOperations);
        BoardController boardController = new BoardController(uiOperations);

        headController.greetUser();
        playerController.createPlayer();
        Board board = boardController.createBoard();

        uiOperations = new UIConsole(new UIDrawBoardCellNumerate(board),scanner);
        uiOperations.drawBoard();
    }
}
