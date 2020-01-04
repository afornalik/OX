package com.afornalik.ox;

import java.util.List;

class Players {

    private final List<Player> players;

    Players (List<Player> players) {
        this.players = players;
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
