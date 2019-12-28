package com.afornalik.ox.model.player;

import com.afornalik.ox.model.board.FieldStatus;

import java.util.Map;

class PlayerContainer {

    private Player playerOne;
    private Player playerTwo;

    void createPlayer(Map<String, Object> playerInfo) {
        if(playerOne == null) {
            playerOne = convertMapToPlayer(playerInfo);
        }else if(playerTwo == null) {
           playerTwo = convertMapToPlayer(playerInfo);
        }
    }

    private Player convertMapToPlayer(Map<String, Object> playerInfo) {
        return new Player.PlayerBuilder((FieldStatus)playerInfo.get("FieldStatus"))
                .name((String)playerInfo.get("name"))
                .score((int)playerInfo.get("score"))
                .first((boolean)playerInfo.get("first"))
                .build();
    }

    String showPlayerOne() {
        return playerOne.toString();
    }

    String showPlayerTwo() {
        return playerTwo.toString();
    }
}
