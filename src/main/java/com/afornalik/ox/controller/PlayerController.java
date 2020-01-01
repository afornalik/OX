package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.Field;
import com.afornalik.ox.model.player.PlayerContainer;
import com.afornalik.ox.view.print.UIOperations;

import java.util.HashMap;
import java.util.Map;

class PlayerController {

    private final UIOperations uiOperations;
    private final PlayerContainer playerContainer = new PlayerContainer();

    PlayerController(UIOperations uiOperations) {
        this.uiOperations = uiOperations;
    }

    PlayerContainer createTwoPlayer() {
        uiOperations.print("\nPlayer 1");
        Map<String, Object> player1Statistics = setPlayer(Field.EMPTY);
        uiOperations.print("\nPlayer 2");
        Map<String, Object> player2Statistics = setPlayer((Field) player1Statistics.get("Field"));
        setFirstMove(player1Statistics);
        if ((boolean) player1Statistics.get("first")) {
            player2Statistics.put("first", false);
        } else {
            player2Statistics.put("first", true);
        }
        playerContainer.createPlayer(player1Statistics);
        playerContainer.createPlayer(player2Statistics);
        uiOperations.print(playerContainer.getPlayer(0));
        uiOperations.print(playerContainer.getPlayer(1));
        return playerContainer;
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
        uiOperations.print("  name : ");
        playerAttributes.put("name", uiOperations.read());
    }

    private void setFirstMove(Map<String, Object> playerAttributes) {
        do {
            uiOperations.print("Which player make first move ? (1/2) ");
            String tempSymbol = uiOperations.read();
            if (tempSymbol.equalsIgnoreCase("1")) {
                playerAttributes.put("first", true);
            } else if (tempSymbol.equalsIgnoreCase("2")) {
                playerAttributes.put("first", false);
            }
        } while (!playerAttributes.containsKey("first"));
    }

    private void setMark(Map<String, Object> playerAttributes) {
        do {
            uiOperations.print("Select X or O mark ");
            String tempSymbol = uiOperations.read().toUpperCase();
            if (tempSymbol.equals(Field.X.toString()) || (tempSymbol.equals(Field.O.toString()))) {
                playerAttributes.put("Field", Field.valueOf(tempSymbol));
            }
        } while (!playerAttributes.containsKey("Field"));
    }
}
