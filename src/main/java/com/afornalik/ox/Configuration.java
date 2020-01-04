package com.afornalik.ox;

import com.afornalik.ox.view.UISimple;

import java.util.List;
import java.util.Map;

class Configuration {

    private final UISimple uiSimple;
    private final Map<String, String> args;

    Configuration(UISimple uiSimple, Map<String, String> args) {
        this.uiSimple = uiSimple;
        this.args = args;
    }

    Players createTwoPlayer() {

        greetUser();

        String argsName = null;
        String argsNameSecondPlayer = null;
        String argsField = null;
        String argsFirstMove = null;

        if (args != null && args.size() > 0) {
            argsName = args.get("name");
            argsNameSecondPlayer = args.get("name2");
            argsField = args.get("Field");
            argsFirstMove = args.get("first");
        }

        uiSimple.print("\nPlayer 1\n");
        Player player1 = createPlayer(Field.EMPTY, argsName, argsField,argsFirstMove);
        uiSimple.print("\nPlayer 2\n");
        Player player2 = createPlayer(player1.getSign(), argsNameSecondPlayer, argsField, String.valueOf(player1.isFirst()));

        return new Players(List.of(player1,player2));
    }

    void greetUser() {
        uiSimple.print("Welcome in game OX\n");
    }

    private Player createPlayer(Field field, String argsName, String argsField, String isFirst) {
        String name = createName(argsName);
        Field playerMark;
        boolean mark = false;
        if (field == Field.EMPTY) {
            playerMark = createMark(argsField);
        } else {
            if (field == Field.O) {
                playerMark =  Field.X;
            } else {
                playerMark =  Field.O;
            }
        }
        if (isFirst == null){
            mark = whoMakeFirstMove(isFirst);
        }
        return new Player.PlayerBuilder(playerMark)
                .first(mark)
                .name(name)
                .score(0)
                .build();
    }

    private String createName(String argsName) {
        uiSimple.print("  name : ");
        if (argsName != null) {
            uiSimple.print(argsName + "\n");
            return argsName;
        } else {
            return uiSimple.read();
        }
    }

    private boolean whoMakeFirstMove(String argsFirstMove) {
        do {
            uiSimple.print("Which player make first move ? (1/2) ");
            String tempSymbol;
            if (argsFirstMove != null) {
                tempSymbol = argsFirstMove;
                uiSimple.print(argsFirstMove + "\n\n");
            } else {
                tempSymbol = uiSimple.read();
            }
            if (tempSymbol.equalsIgnoreCase("1") || tempSymbol.equalsIgnoreCase("true")) {
               return true;
            } else if (tempSymbol.equalsIgnoreCase("2") || tempSymbol.equalsIgnoreCase("false")) {
               return false;
            }
        } while (true);
    }

    private Field createMark(String argsField) {
        Field playerField;
        do {
            uiSimple.print("Select X or O mark : ");
            String tempSymbol;
            if (argsField != null) {
                uiSimple.print(argsField + "\n");
                tempSymbol = argsField.toUpperCase();
            } else {
                tempSymbol = uiSimple.read().toUpperCase();
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
        uiSimple.print("\nSelect board size : ");
        int borderSize;
        if (args != null && args.get("size") != null) {
            borderSize = Integer.parseInt(args.get("size"));
            uiSimple.print(borderSize + "\n");
        } else {
            borderSize = uiSimple.readNumber();
        }
        uiSimple.print("Select condition size : ");
        int conditionSize;
        if (args != null && args.get("condition") != null) {
            conditionSize = Integer.parseInt(args.get("condition"));
            uiSimple.print(conditionSize + "\n");
        } else {
            conditionSize = uiSimple.readNumber();
        }
        return new Board(borderSize, conditionSize);
    }


}
