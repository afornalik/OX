package com.afornalik.ox;

import com.afornalik.ox.view.UI;
import com.afornalik.ox.view.UIFromFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class MainApp {


    public static void main(String[] args) {

        UI ui;

        if (args.length > 0 && args[0].equalsIgnoreCase("-h")){
            Generator generator = new Generator();
            generator.horizontal();
        }else {

            File file = new File("result.txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }


            int counter = 0;
            do {
                ui = getUi(args, counter);
                GameBuilder gameBuilder = new GameBuilder(ui);

                List<Player> players = gameBuilder.createTwoPlayer();
                Board board = gameBuilder.createBoard();

                Match match = new Match(ui, board, players);
                match.nextRound();
                counter++;
                if (ui instanceof UIFromFile) {
                    try {
                        ((UIFromFile) ui).getWriter().close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            } while (ui.getAllLines().size() > 0);

        }
    }


    private static UI getUi(String[] args, int counter) {
        String file = "horizontal.txt";
        Scanner scanner = new Scanner(System.in);
        UI ui;
        if (args.length > 0 && args[0].equalsIgnoreCase("-t")) {
            if (args.length > 1 && args[1] != null) {
                File fileToLoad = new File(args[1]);
                if (fileToLoad.exists()) {
                    ui = new UIFromFile(scanner, fileToLoad, counter);
                } else {
                    ui = new UIFromFile(scanner, new File(file), counter);
                }
            } else {
                ui = new UIFromFile(scanner, new File(file), counter);
            }

        } else {
            ui = new UI(scanner);
        }
        return ui;
    }
}

