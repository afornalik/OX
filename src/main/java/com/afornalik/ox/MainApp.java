package com.afornalik.ox;

import com.afornalik.ox.view.UI;
import com.afornalik.ox.view.UIFromFile;

import java.io.File;
import java.util.List;
import java.util.Scanner;

class MainApp {

    public static void main(String[] args) {

        UI ui = getUi(args);
        GameBuilder gameBuilder = new GameBuilder(ui);

        List<Player> players = gameBuilder.createTwoPlayer();
        Board board = gameBuilder.createBoard();

        Match match = new Match(ui, board, players);
        match.nextRound();

        if (ui instanceof UIFromFile) {
            ((UIFromFile) ui).getWriter().close();
        }
    }



    private static UI getUi(String[] args) {
        String file = "test.txt";
        Scanner scanner = new Scanner(System.in);
        UI ui;
        if(args.length > 0 && args[0].equalsIgnoreCase("-t")){
            if(args.length > 1 && args[1] != null) {
                File fileToLoad = new File(args[1]);
                if (fileToLoad.exists()) {
                    ui = new UIFromFile(scanner, fileToLoad);
                }else {
                    ui = new UIFromFile(scanner, new File(file));
                }
            }else {
                ui = new UIFromFile(scanner, new File(file));
            }
        }else {
            ui = new UI(scanner);
        }
        return ui;
    }
}
