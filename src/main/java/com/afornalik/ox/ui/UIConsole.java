package com.afornalik.ox.ui;

import java.util.Scanner;

public class UIConsole implements UIOutputDestination, UIInput {

    private final Scanner scanner;

    public UIConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void print(String dummyString) {
        System.out.print(dummyString);
    }

    @Override
    public String read() {
        return scanner.next();
    }
}
