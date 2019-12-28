package com.afornalik.ox;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.controller.GameProgress;
import com.afornalik.ox.view.UIConsole;
import com.afornalik.ox.view.UIOperations;
import com.afornalik.ox.view.draw.UIDrawBoardSideNumerate;

import java.util.InputMismatchException;
import java.util.Scanner;

class MainApp {

    public static void main(String[] args) {
        System.out.println("Welcome");
        System.out.println("give board range (prefer from 0 to 50) : ");
        Board board;
        try {
            board = new Board(new Scanner(System.in).nextInt());
        } catch (InputMismatchException e) {
            System.out.println("range set to 3");
            board = new Board(3);
        }
        UIOperations ui = new UIConsole(new UIDrawBoardSideNumerate(board),new Scanner(System.in));
        GameProgress gameProgress = new GameProgress(ui);
        gameProgress.oneTurn(board);
    }
}
