package com.afornalik.ox;

import com.afornalik.ox.view.UI;
import com.afornalik.ox.view.UIFromFile;
import org.checkerframework.checker.units.qual.A;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class MainApp {


    private static  AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {

        UI ui;
        args = new String[2];
        args[0] = "-t";
        args[1] = "draw.txt";

        String[] finalArgs = args;



        List<Thread> runnables = new ArrayList<>();


        for(int i = 0; i <4; i++) {
            runnables.add(new Thread(() -> doPrtint(finalArgs)));
        }
        for (Thread r : runnables) {
            r.start();
        }


        if (args.length > 0 && args[0].equalsIgnoreCase("-h")){
            Generator generator = new Generator();
            generator.horizontal();
        }else {


        }
    }

    private static void doPrtint(String[] args) {
        UI ui;
        File file = new File("draw.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int counter = 0;
        do {
            ui = getUi(args,atomicInteger.getAndIncrement() );
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

        } while (ui.getAllLines().size() > 0);
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

