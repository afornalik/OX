package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.FieldStatus;
import com.afornalik.ox.model.player.PlayerContainer;
import com.afornalik.ox.view.UIOperations;

import java.util.HashMap;
import java.util.Map;

class PlayerController {

    private final UIOperations uiOperations;

    PlayerController(UIOperations uiOperations) {
        this.uiOperations = uiOperations;
    }

    String createPlayer() {

        Map<String,Object> playerAttributes = new HashMap<>();

        uiOperations.print("Player name : ");
        playerAttributes.put("name",uiOperations.read());

        do {
            uiOperations.print("Select X or O mark ");
            String tempSymbol = uiOperations.read();
            if(tempSymbol.equalsIgnoreCase("x")){
                playerAttributes.put("FieldStatus", FieldStatus.X);
            }else if(tempSymbol.equalsIgnoreCase("o")){
                playerAttributes.put("FieldStatus", FieldStatus.O);
            }
        }while(!playerAttributes.containsKey("FieldStatus"));

        do {
            uiOperations.print("Is this player make first move ? (Y/N) ");
            String tempSymbol = uiOperations.read();
            if(tempSymbol.equalsIgnoreCase("y")){
                playerAttributes.put("first", true);
            }else if(tempSymbol.equalsIgnoreCase("n")){
                playerAttributes.put("first", false);
            }
        }while(!playerAttributes.containsKey("first"));

        uiOperations.print("Score set to 0 \n");
        playerAttributes.put("score",0);

        PlayerContainer playerContainer = new PlayerContainer();
        playerContainer.createPlayer(playerAttributes);



        return playerContainer.showPlayerOne();

    }
}
