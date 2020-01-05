package com.afornalik.ox;

import com.afornalik.ox.view.UI;

import java.util.List;
import java.util.Scanner;

class MainApp {

    public static void main(String[] args) {
   /*     args = new String[16];
        args[0] = "Kuba";
        args[1] = "x";
        args[2] = "Karolina";
        args[3] = "2";
        args[4] = "5";
        args[5] = "4";
        args[6] = "1";
        args[7] = "5";
        args[8] = "2";
        args[9] = "9";
        args[10] = "3";
        args[11] = "13";
        args[12] = "14";
        args[13] = "18";
        args[14] = "11";
        args[15] = "25";
*/
        ArgumentConverter argumentConverter = new ArgumentConverter(args);

        Scanner scanner = new Scanner(System.in);
        UI ui = new UI(scanner);
        GameBuilder gameBuilder = new GameBuilder(ui, argumentConverter.convertToConfiguration());

        List<Player> players = gameBuilder.createTwoPlayer();
        Board board = gameBuilder.createBoard();

        Match match = new Match(ui, board, players, argumentConverter.convertToMove());
        match.nextRound(0);
    }
}
