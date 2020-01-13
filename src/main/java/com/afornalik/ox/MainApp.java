package com.afornalik.ox;

import com.afornalik.ox.view.UI;
import com.afornalik.ox.view.UIFromFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

class MainApp {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {

        UI ui;
        List<Thread> runnable = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            runnable.add(new Thread(() -> doPrint(args)));
        }
        for (Thread r : runnable) {
            r.start();
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("-h")) {
            Generator.horizontal();
            Generator.vertical();
            Generator.diagonalLeft();
            Generator.diagonalRight();
        }
    }

    private static void doPrint(String[] args) {
        UI ui;
        File file = new File("draw.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        do {
            ui = getUi(args, atomicInteger.getAndIncrement());
            GameBuilder gameBuilder = new GameBuilder(ui);

            List<Player> players = gameBuilder.createTwoPlayer();
            Board board = gameBuilder.createBoard();

            Match match = new Match(ui, board, players);
            match.nextRound();

            if (ui instanceof UIFromFile) {
                try {
                    ((UIFromFile) ui).getWriter().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } while (ui.getAllLines());
    }


    private static UI getUi(String[] args, int counter) {
        String file = ".txt";
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

