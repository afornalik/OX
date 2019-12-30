package com.afornalik.ox.model.player;

import com.afornalik.ox.model.board.FieldStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerContainer {

    private List<Player> players = new ArrayList<>();

    public void createPlayer(Map<String, Object> playerInfo) {
           players.add(convertMapToPlayer(playerInfo));
    }

    private Player convertMapToPlayer(Map<String, Object> playerInfo) {
        return new Player.PlayerBuilder((FieldStatus)playerInfo.get("FieldStatus"))
                .name((String)playerInfo.get("name"))
                .score((int)playerInfo.get("score"))
                .first((boolean)playerInfo.get("first"))
                .build();
    }

    public String getPlayer(int index) {
        return players.get(index).toString();
    }


}
