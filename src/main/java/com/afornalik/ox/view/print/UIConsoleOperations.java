package com.afornalik.ox.view.print;

import com.afornalik.ox.view.print.UIOperations;

import java.util.Scanner;

public class UIConsoleOperations implements UIOperations {

    private final Scanner scanner;

    public UIConsoleOperations(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void print(String string) {
        System.out.print(string);
    }

    @Override
    public int readNumber() {
        String stringToParse ;
        int integerVal;
        do {
            stringToParse = scanner.next();
            try {
                integerVal = Integer.parseInt(stringToParse);
                break;
            } catch (NumberFormatException e) {
                this.print(" insert number ");
            }
        } while (true);
        return integerVal;
    }

    @Override
    public String read() {
        return scanner.next();
    }
}
