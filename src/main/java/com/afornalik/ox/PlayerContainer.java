package com.afornalik.ox.model.player;

import com.afornalik.ox.model.board.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerContainer {

    private final List<Player> players = new ArrayList<>();

    public void createPlayer(Map<String, Object> playerInfo) {
        players.add(convertMapToPlayer(playerInfo));
    }

    private Player convertMapToPlayer(Map<String, Object> playerInfo) {
        return new Player.PlayerBuilder((Field) playerInfo.get("Field"))
                .name((String) playerInfo.get("name"))
                .score((int) playerInfo.get("score"))
                .first((boolean) playerInfo.get("first"))
                .build();
    }

    public String getPlayer(int index) {
        return players.get(index).toString();
    }

    public Player isFirst() {
        return players.stream().filter(Player::isFirst).findFirst().get();
    }

    //to refactor
    public Player isLast() {
        return players.stream().filter(player -> !player.isFirst()).findFirst().get();
    }
}
