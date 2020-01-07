package com.afornalik.ox;

import com.afornalik.ox.view.UI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

class GameBuilder {

    private final Logger logger = LogManager.getLogger(GameBuilder.class);
    private final UI ui;

    GameBuilder(UI ui) {
        this.ui = ui;
    }

    List<Player> createTwoPlayer() {

        ui.print("Welcome in game OX\n");

        ui.print("\nPlayer 1\n");
        Player player1 = createPlayer(Field.EMPTY,0);
        ui.print("\nPlayer 2\n");
        Player player2 = createPlayer(player1.getSign(), player1.getSequence());

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.sort(Comparator.comparing(Player::getSequence));

        return players;
    }

    private Player createPlayer(Field field, int sequence) {
        String name = createName();
        Field playerMark;
        int playerSequence = 0;
        if (field == Field.EMPTY) {
            playerMark = createMark(field);
        } else {
            if (field == Field.O) {
                playerMark = Field.X;
            } else {
                playerMark = Field.O;
            }
        }
        if(sequence == 0) {
            playerSequence = whoMakeFirstMove(sequence);
        }
        return new Player.PlayerBuilder(playerMark)
                .sequence(playerSequence)
                .name(name)
                .score(0)
                .build();
    }

    private String createName() {
        ui.print("  name : ");
        return ui.read();
    }

    private int whoMakeFirstMove(int argsFirstMove) {
        ui.print("Which player make first move ? (1/2) ");
        if (argsFirstMove != 0) {
            ui.print(argsFirstMove + "\n\n");
            return argsFirstMove;
        }
        return ui.readNumber();

    }

    private Field createMark(Field field) {
        Field playerField;
        do {
            ui.print("Select X or O mark : ");
            String tempSymbol;
            if (field != Field.EMPTY) {
                tempSymbol = field.toString();
            } else {
                tempSymbol = ui.read().toUpperCase();
            }
            playerField = checkSymbolIsXOrO(tempSymbol);
        } while (playerField == Field.EMPTY);
        return playerField;
    }

    private Field checkSymbolIsXOrO(String tempSymbol) {
        if (tempSymbol.equals(Field.X.toString()) || tempSymbol.equals(Field.O.toString())) {
            return Field.valueOf(tempSymbol);
        }
        return Field.EMPTY;
    }

    Board createBoard() {
        return new Board(receiveSize("Select board size : "), receiveSize("Select condition size : "));
    }

    private int receiveSize(String s) {
        ui.print(s);
        int conditionSize;
        conditionSize = ui.readNumber();
        return conditionSize;
    }
}
