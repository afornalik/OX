package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.FieldStatus;
import com.afornalik.ox.model.player.PlayerContainer;
import com.afornalik.ox.view.print.UIOperations;

import java.util.HashMap;
import java.util.Map;

class PlayerController {

    private final UIOperations uiOperations;
    private PlayerContainer playerContainer = new PlayerContainer();

    PlayerController(UIOperations uiOperations) {
        this.uiOperations = uiOperations;
    }

    PlayerContainer createTwoPlayer() {
        uiOperations.print("\nPlayer 1");
        Map<String,Object> player1Statistics = setPlayer();
        uiOperations.print("\nPlayer 2");
        Map<String,Object> player2Statistics = setPlayer();
        setFirstMove(player1Statistics);
        if((boolean) player1Statistics.get("first")){
            player2Statistics.put("first",false);
        }else {
            player2Statistics.put("first",true);
        }

        playerContainer.createPlayer(player1Statistics);
        playerContainer.createPlayer(player2Statistics);


        return playerContainer;
    }

    private Map<String, Object> setPlayer() {
        Map<String, Object> playerAttributes = new HashMap<>();

        setName(playerAttributes);
        setMark(playerAttributes);
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
            String tempSymbol = uiOperations.read();
            if (tempSymbol.equalsIgnoreCase(FieldStatus.X.toString())) {
                playerAttributes.put("FieldStatus", FieldStatus.X);
            } else if (tempSymbol.equalsIgnoreCase(FieldStatus.O.toString())) {
                playerAttributes.put("FieldStatus", FieldStatus.O);
            }
        } while (!playerAttributes.containsKey("FieldStatus"));
    }
}
