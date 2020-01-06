package com.afornalik.ox;

import com.afornalik.ox.view.UI;

import java.util.*;

class GameBuilder {

    private final UI ui;
    private final Map<String, String> args;

    GameBuilder(UI ui, Map<String, String> args) {
        this.ui = ui;
        this.args = args;
    }

    List<Player> createTwoPlayer() {

        greetUser();

        String argsName = null;
        String argsNameSecondPlayer = null;
        String argsField = null;
        String argsFirstMove = "0";

        if (args != null && args.size() > 0) {
            argsName = args.get("name");
            argsNameSecondPlayer = args.get("name2");
            argsField = args.get("Field");
            argsFirstMove = args.get("first");
        }

        ui.print("\nPlayer 1\n");
        Player player1 = createPlayer(Field.EMPTY, argsName, argsField, Integer.valueOf(argsFirstMove));
        ui.print("\nPlayer 2\n");
        Player player2 = createPlayer(player1.getSign(), argsNameSecondPlayer, argsField, player1.getOrder());

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.sort(Comparator.comparing(Player::getOrder));

        return players;
    }

    void greetUser() {
        ui.print("Welcome in game OX\n");
    }

    private Player createPlayer(Field field, String argsName, String argsField, int argsFirstMove) {
        String name = createName(argsName);
        Field playerMark;
        int mark = 0;
        if (field == Field.EMPTY) {
            playerMark = createMark(argsField);
        } else {
            if (field == Field.O) {
                playerMark = Field.X;
            } else {
                playerMark = Field.O;
            }
        }
        if (argsFirstMove == 0) {
            mark = whoMakeFirstMove(argsFirstMove);
        }
        return new Player.PlayerBuilder(playerMark)
                .order(mark)
                .name(name)
                .score(0)
                .build();
    }

    private String createName(String argsName) {
        ui.print("  name : ");
        if (argsName != null) {
            ui.print(argsName + "\n");
            return argsName;
        } else {
            return ui.read();
        }
    }

    private int whoMakeFirstMove(int argsFirstMove) {
        ui.print("Which player make first move ? (1/2) ");
        if (argsFirstMove != 0) {
            ui.print(argsFirstMove + "\n\n");
            return argsFirstMove;
        }
        return ui.readNumber();

    }

    private Field createMark(String argsField) {
        Field playerField;
        do {
            ui.print("Select X or O mark : ");
            String tempSymbol;
            if (argsField != null) {
                ui.print(argsField + "\n");
                tempSymbol = argsField.toUpperCase();
            } else {
                tempSymbol = ui.read().toUpperCase();
            }
            playerField = checkSymbolIsXOrO(tempSymbol);
        } while (playerField == Field.EMPTY);
        return playerField;
    }

    private Field checkSymbolIsXOrO(String tempSymbol) {
        if (tempSymbol.equals(Field.X.toString()) || (tempSymbol.equals(Field.O.toString()))) {
            return Field.valueOf(tempSymbol);
        }
        return Field.EMPTY;
    }

    Board createBoard() {
        ui.print("\nSelect board size : ");
        int borderSize;
        if (args != null && args.get("size") != null) {
            borderSize = Integer.parseInt(args.get("size"));
            ui.print(borderSize + "\n");
        } else {
            borderSize = ui.readNumber();
        }
        ui.print("Select condition size : ");
        int conditionSize;
        if (args != null && args.get("condition") != null) {
            conditionSize = Integer.parseInt(args.get("condition"));
            ui.print(conditionSize + "\n");
        } else {
            conditionSize = ui.readNumber();
        }
        return new Board(borderSize, conditionSize);
    }


}
