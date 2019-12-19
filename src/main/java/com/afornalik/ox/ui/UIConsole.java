package com.afornalik.ox.ui;

public class UIConsole implements UIOutputDestination{

    public void say(String dummyString) {
        System.out.print(dummyString);
    }
}
