package com.afornalik.ox;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class PlayerContainer {

    private final List<Player> players = new ArrayList<>();

    void createPlayer(Map<String, Object> playerInfo) {
        players.add(convertMapToPlayer(playerInfo));
    }

    private Player convertMapToPlayer(Map<String, Object> playerInfo) {
        return new Player.PlayerBuilder((Field) playerInfo.get("Field"))
                .name((String) playerInfo.get("name"))
                .score((int) playerInfo.get("score"))
                .first((boolean) playerInfo.get("first"))
                .build();
    }

    String getPlayer(int index) {
        return players.get(index).toString();
    }

    Player isFirst() {
        return players.stream().filter(Player::isFirst).findFirst().get();
    }

    Player isLast() {
        return players.stream().filter(player -> !player.isFirst()).findFirst().get();
    }
}
