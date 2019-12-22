package com.afornalik.ox.progress;

import com.afornalik.ox.ui.UI;

public class GameProgress {

    private final UI ui;

    public GameProgress(UI ui) {
        this.ui = ui;
    }

    public void start() {
        ui.printBoard();
    }
}
