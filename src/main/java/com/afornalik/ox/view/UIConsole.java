package com.afornalik.ox.view;

import java.util.Scanner;

public class UIConsole implements UIOperations {

    private final Scanner scanner;

    public UIConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public void print(String string) {
        System.out.print(string);
    }

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
}
