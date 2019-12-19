package com.afornalik.ox.ui;

public class UIConsole implements UIOutputDestination{

    public void print(String dummyString) {
        System.out.print(dummyString);
    }
}
