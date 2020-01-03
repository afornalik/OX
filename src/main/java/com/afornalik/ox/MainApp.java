package com.afornalik.ox;

import com.afornalik.ox.view.DrawBoardType;
import com.afornalik.ox.view.UIExtended;
import com.afornalik.ox.view.UISimple;

import java.util.Scanner;

class MainApp {

    public static void main(String[] args) {
        args = new String[6];
        args[0] = "Andrzej";
        args[1] = "x";
        args[2] = "Kamila";
        args[3] = "2";
        args[4] = "5";
        args[5] = "4";



        ArgumentConverter argumentConverter = new ArgumentConverter(args);

        Scanner scanner = new Scanner(System.in);
        UISimple uiSimple = new UISimple(scanner);
        Configuration configuration = new Configuration(uiSimple,argumentConverter.convertToConfiguration());

        PlayerContainer playerContainer = configuration.createTwoPlayer();
        Board board = configuration.createBoard();

        UIExtended uiExtended = new UIExtended(scanner, DrawBoardType.CELL, board);
        Match match = new Match(uiExtended, board, playerContainer);
        match.makeATurn();
    }
}
