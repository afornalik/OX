package com.afornalik.ox;

import com.afornalik.ox.board.Board;
import com.afornalik.ox.progress.GameProgress;
import com.afornalik.ox.ui.UI;
import com.afornalik.ox.ui.UIConsole;
import com.afornalik.ox.ui.UIDrawBoard;

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
        UI ui = new UI(new UIConsole(new Scanner(System.in)), new UIDrawBoard(board));
        GameProgress gameProgress = new GameProgress(ui);
        gameProgress.oneTurn(board);
    }
}
