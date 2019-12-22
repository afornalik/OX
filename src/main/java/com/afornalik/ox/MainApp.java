package com.afornalik.ox;

import com.afornalik.ox.board.Board;
import com.afornalik.ox.board.FieldStatus;
import com.afornalik.ox.board.OutOfBoardException;
import com.afornalik.ox.progress.GameProgress;
import com.afornalik.ox.ui.UI;
import com.afornalik.ox.ui.UIConsole;
import com.afornalik.ox.ui.UIDrawBoard;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome");
        System.out.println("give board range (prefer from 0 to 50) : ");
        Board board;
        try {
            board = new Board(scanner.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("range set to 3");
            board = new Board(3);
        }
        GameProgress gameProgress = new GameProgress(new UI(new UIConsole(), new UIDrawBoard(board)));
        String control;
        int mod = 0;

        do {
            System.out.print("Type x to exti or give a number : ");
            control = scanner.next();
            try {
                FieldStatus fieldStatus;
                int position = Integer.parseInt(control);
                if (mod % 2 == 0) {
                    fieldStatus = FieldStatus.X;
                } else {
                    fieldStatus = FieldStatus.O;
                }
                mod++;
                board.insertBoardField(position, fieldStatus);
            } catch (NumberFormatException | OutOfBoardException e) {
                System.out.println("use numbers or 'x'");
            }
            gameProgress.start();
            System.out.println("\n");
        } while (!control.equals("x"));
        System.out.println("exit");
    }
}
