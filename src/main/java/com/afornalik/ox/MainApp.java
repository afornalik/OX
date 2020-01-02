package com.afornalik.ox;

import com.afornalik.ox.view.DrawBoardType;
import com.afornalik.ox.view.UIExtended;
import com.afornalik.ox.view.UISimple;

import java.util.Scanner;

class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UISimple uiSimple = new UISimple(scanner);
        Configuration configuration = new Configuration(uiSimple);

        PlayerContainer playerContainer = configuration.createTwoPlayer();
        Board board = configuration.createBoard();

        UIExtended uiExtended = new UIExtended(scanner, DrawBoardType.CELL, board);
        Match match = new Match(uiExtended, board, playerContainer);
        match.makeATurn();
    }
}
