package com.afornalik.ox.ui;

public class UIConsole implements UIOutputDestination {

    public void print(String string) {
        System.out.print(string);
    }
}
