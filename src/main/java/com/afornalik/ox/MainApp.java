package com.afornalik.ox;

import com.afornalik.ox.view.DrawBoardType;
import com.afornalik.ox.view.UIExtended;
import com.afornalik.ox.view.UISimple;

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
        UISimple uiSimple = new UISimple(scanner);
        Configuration configuration = new Configuration(uiSimple,argumentConverter.convertToConfiguration());

        PlayerContainer playerContainer = configuration.createTwoPlayer();
        Board board = configuration.createBoard();

        UIExtended uiExtended = new UIExtended(scanner, DrawBoardType.CELL, board);
        Match match = new Match(uiExtended, board, playerContainer, argumentConverter.convertToMove());
        match.makeATurn(0);
    }
}
