package com.afornalik.ox;

import com.afornalik.ox.board.Board;
import com.afornalik.ox.progress.GameProgress;
import com.afornalik.ox.ui.UI;
import com.afornalik.ox.ui.UIConsole;
import com.afornalik.ox.ui.UIDrawBoard;

public class MainApp {

    public static void main(String[] args) {

        Board board = new Board(9);
        GameProgress gameProgress = new GameProgress(new UI(new UIConsole(),new UIDrawBoard(board)),board);

        gameProgress.start();
    }
}
