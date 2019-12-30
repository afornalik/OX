package com.afornalik.ox.view;

import com.afornalik.ox.view.print.UIOperations;

public class UISimple implements UIOperations {

    private final UIOperations uiOperations;

    public UISimple(UIOperations uiOperations) {
        this.uiOperations = uiOperations;
    }

    @Override
    public void print(String string) {
        uiOperations.print(string);
    }

    @Override
    public int readNumber() {
        return uiOperations.readNumber();
    }

    @Override
    public String read() {
        return uiOperations.read();
    }
}
