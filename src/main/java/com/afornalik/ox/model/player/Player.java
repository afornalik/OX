package com.afornalik.ox.model.player;

import com.afornalik.ox.model.board.FieldStatus;

class Player {

    private String name = "player" ;
    private int score = 0;
    private FieldStatus sign = FieldStatus.EMPTY;
    private boolean first = true;

    int getScore() {
        return score;
    }

    String getName() {
        return name;
    }

    FieldStatus getSign() {
        return sign;
    }

    boolean isFirst() {
        return first;
    }
}
