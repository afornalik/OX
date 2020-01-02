package com.afornalik.ox;

import com.afornalik.ox.view.UISimple;

import java.util.HashMap;
import java.util.Map;

class Configuration {

    private final UISimple uiSimple;
    private final PlayerContainer playerContainer = new PlayerContainer();

    Configuration(UISimple uiSimple) {
        this.uiSimple = uiSimple;
    }

    PlayerContainer createTwoPlayer() {

        greetUser();

        uiSimple.print("\nPlayer 1");
        Map<String, Object> player1Statistics = setPlayer(Field.EMPTY);
        uiSimple.print("\nPlayer 2");
        Map<String, Object> player2Statistics = setPlayer((Field) player1Statistics.get("Field"));
        setFirstMove(player1Statistics);
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
        uiSimple.print("Select board size :");
        int borderSize = uiSimple.readNumber();
        uiSimple.print("Select condition size :");
        int conditionSize = uiSimple.readNumber();
        return new Board(borderSize, conditionSize);
    }


    void greetUser() {
        uiSimple.print("Welcome in game OX\n");
    }

    private Map<String, Object> setPlayer(Field field) {
        Map<String, Object> playerAttributes = new HashMap<>();

        setName(playerAttributes);
        if (field == Field.EMPTY) {
            setMark(playerAttributes);
        } else {
            if (field == Field.O) {
                playerAttributes.put("Field", Field.X);
            } else {
                playerAttributes.put("Field", Field.O);
            }
        }
        setScore(playerAttributes);
        return playerAttributes;
    }

    private void setScore(Map<String, Object> playerAttributes) {
        playerAttributes.put("score", 0);
    }

    private void setName(Map<String, Object> playerAttributes) {
        uiSimple.print("  name : ");
        playerAttributes.put("name", uiSimple.read());
    }

    private void setFirstMove(Map<String, Object> playerAttributes) {
        do {
            uiSimple.print("Which player make first move ? (1/2) ");
            String tempSymbol = uiSimple.read();
            if (tempSymbol.equalsIgnoreCase("1")) {
                playerAttributes.put("first", true);
            } else if (tempSymbol.equalsIgnoreCase("2")) {
                playerAttributes.put("first", false);
            }
        } while (!playerAttributes.containsKey("first"));
    }

    private void setMark(Map<String, Object> playerAttributes) {
        do {
            uiSimple.print("Select X or O mark ");
            String tempSymbol = uiSimple.read().toUpperCase();
            if (tempSymbol.equals(Field.X.toString()) || (tempSymbol.equals(Field.O.toString()))) {
                playerAttributes.put("Field", Field.valueOf(tempSymbol));
            }
        } while (!playerAttributes.containsKey("Field"));
    }


}
