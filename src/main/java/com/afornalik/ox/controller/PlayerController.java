package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.FieldStatus;
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
        Map<String, Object> player1Statistics = setPlayer(FieldStatus.EMPTY);
        uiOperations.print("\nPlayer 2");
        Map<String, Object> player2Statistics = setPlayer((FieldStatus) player1Statistics.get("FieldStatus"));
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

    private Map<String, Object> setPlayer(FieldStatus fieldStatus) {
        Map<String, Object> playerAttributes = new HashMap<>();

        setName(playerAttributes);
        if (fieldStatus == FieldStatus.EMPTY) {
            setMark(playerAttributes);
        } else {
            if (fieldStatus == FieldStatus.O) {
                playerAttributes.put("FieldStatus", FieldStatus.X);
            } else {
                playerAttributes.put("FieldStatus", FieldStatus.O);
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
            if (tempSymbol.equals(FieldStatus.X.toString()) || (tempSymbol.equals(FieldStatus.O.toString()))) {
                playerAttributes.put("FieldStatus", FieldStatus.valueOf(tempSymbol));
            }
        } while (!playerAttributes.containsKey("FieldStatus"));
    }
}
