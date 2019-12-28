package com.afornalik.ox.model.player;

import com.afornalik.ox.model.board.FieldStatus;

class Player {

    private final String name;
    private int score;
    private final FieldStatus sign;
    private final boolean first;

    Player(PlayerBuilder playerBuilder) {
        this.name = playerBuilder.name;
        this.score = playerBuilder.score;
        this.sign = playerBuilder.sign;
        this.first = playerBuilder.first;
    }

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

    public void setScore(int score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", sign=" + sign +
                ", first=" + first +
                '}';
    }

    static class PlayerBuilder {
        private String name = "player";
        private int score = 0;
        private final FieldStatus sign;
        private boolean first = true;

        PlayerBuilder(FieldStatus sign) {
            this.sign = sign;
        }

        PlayerBuilder name(String name) {
            this.name = name;
            return this;
        }

        PlayerBuilder score(int score) {
            this.score = score;
            return this;
        }


        PlayerBuilder first(boolean first) {
            this.first = first;
            return this;
        }

        Player build() {
            return new Player(this);
        }
    }
}
