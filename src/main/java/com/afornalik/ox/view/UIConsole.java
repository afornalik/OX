package com.afornalik.ox.view;

import com.afornalik.ox.model.board.Board;
import com.afornalik.ox.view.draw.UIDrawBoard;

import java.util.Objects;
import java.util.Scanner;

public class UIConsole implements UIOperations{

    private final UIDrawBoard uiDrawBoard;
    private final Scanner scanner;

    public UIConsole(Scanner scanner) {
        this.scanner = scanner;
        uiDrawBoard = null;
    }

    public UIConsole(UIDrawBoard uiDrawBoard, Scanner scanner) {
        this.uiDrawBoard = uiDrawBoard;
        this.scanner = scanner;
    }

    @Override
    public void print(String string) {
        System.out.print(string);
    }

    @Override
    public int readNumber() {
        String stringToParse = scanner.next();
        int integerVal;
        do {
            try {
                integerVal = Integer.parseInt(stringToParse);
                break;
            } catch (NumberFormatException e) {
                this.print(" Insert number ");
            }
        } while (true);
        return integerVal;
    }

    @Override
    public String read() {
        return scanner.next();
    }

    @Override
    public void drawBoard() {
        print(Objects.requireNonNull(uiDrawBoard).drawBoard());
    }

    @Override
    public void drawBoard(Board board) {
        print(Objects.requireNonNull(uiDrawBoard).drawBoard(board));
    }
}
