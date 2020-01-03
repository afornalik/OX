package com.afornalik.ox;

import com.afornalik.ox.view.UISimple;

import java.util.HashMap;
import java.util.Map;

class Configuration {

    private final UISimple uiSimple;
    private final Map<String, String> args;
    private final PlayerContainer playerContainer = new PlayerContainer();


    Configuration(UISimple uiSimple, Map<String, String> args) {
        this.uiSimple = uiSimple;
        this.args = args;
    }

    PlayerContainer createTwoPlayer() {


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
        uiSimple.print("\nPlayer 1");
        Map<String, Object> player1Statistics = createPlayer(Field.EMPTY, argsName, argsField);
        uiSimple.print("\nPlayer 2");
        Map<String, Object> player2Statistics = createPlayer((Field) player1Statistics.get("Field"), argsNameSecondPlayer, argsField);
        createFirstMove(player1Statistics, argsFirstMove);
        if ((boolean) player1Statistics.get("first")) {
            player2Statistics.put("first", false);
        } else {
            player2Statistics.put("first", true);
        }
        playerContainer.createPlayer(player1Statistics);
        playerContainer.createPlayer(player2Statistics);
        uiSimple.print(playerContainer.getPlayer(0));
        uiSimple.print(playerContainer.getPlayer(1));
        return playerContainer;
    }

    Board createBoard() {
        uiSimple.print("Select board size : ");
        int borderSize;
        if (args != null && args.get("size") != null) {
            borderSize = Integer.parseInt(args.get("size"));
            uiSimple.print(borderSize+"\n");
        } else {
            borderSize = uiSimple.readNumber();
        }
        uiSimple.print("Select condition size : ");
        int conditionSize;
        if (args != null && args.get("condition") != null) {
            conditionSize = Integer.parseInt(args.get("condition"));
            uiSimple.print(conditionSize+"\n");
        } else {
            conditionSize = uiSimple.readNumber();
        }
        return new Board(borderSize, conditionSize);
    }


    void greetUser() {
        uiSimple.print("Welcome in game OX\n");
    }

    private Map<String, Object> createPlayer(Field field, String argsName, String argsField) {
        Map<String, Object> playerAttributes = new HashMap<>();

        createName(playerAttributes, argsName);
        if (field == Field.EMPTY) {
            createMark(playerAttributes, argsField);
        } else {
            if (field == Field.O) {
                playerAttributes.put("Field", Field.X);
            } else {
                playerAttributes.put("Field", Field.O);
            }
        }
        createScore(playerAttributes);
        return playerAttributes;
    }

    private void createScore(Map<String, Object> playerAttributes) {
        playerAttributes.put("score", 0);
    }

    private void createName(Map<String, Object> playerAttributes, String argsName) {
        uiSimple.print("  name : ");
        if (argsName != null) {
            playerAttributes.put("name", argsName);
            uiSimple.print(argsName + "\n");
        } else {
            playerAttributes.put("name", uiSimple.read());
        }
    }

    private void createFirstMove(Map<String, Object> playerAttributes, String argsFirstMove) {
        do {
            uiSimple.print("Which player make first move ? (1/2) ");
            String tempSymbol;
            if (argsFirstMove != null) {
                tempSymbol = argsFirstMove;
                uiSimple.print(argsFirstMove + "\n");
            } else {
                tempSymbol = uiSimple.read();
            }
            if (tempSymbol.equalsIgnoreCase("1")) {
                playerAttributes.put("first", true);
            } else if (tempSymbol.equalsIgnoreCase("2")) {
                playerAttributes.put("first", false);
            }
        } while (!playerAttributes.containsKey("first"));
    }

    private void createMark(Map<String, Object> playerAttributes, String argsField) {
        do {
            uiSimple.print("Select X or O mark : ");
            String tempSymbol;
            if (argsField != null) {
                tempSymbol = argsField.toUpperCase();
                uiSimple.print(argsField + "\n");
            } else {
                tempSymbol = uiSimple.read().toUpperCase();
            }
            if (tempSymbol.equals(Field.X.toString()) || (tempSymbol.equals(Field.O.toString()))) {
                playerAttributes.put("Field", Field.valueOf(tempSymbol));
            }
        } while (!playerAttributes.containsKey("Field"));
    }


}
