package com.afornalik.ox;

public class Player {

    private final String name;
    private int score;
    private final Field sign;
    private final boolean first;

    private Player(PlayerBuilder playerBuilder) {
        this.name = playerBuilder.name;
        this.score = playerBuilder.score;
        this.sign = playerBuilder.sign;
        this.first = playerBuilder.first;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public Field getSign() {
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
        return "Player " +
                "name is " + name +
                " ,has score = " + score +
                " ,use sign = " + sign +
                " , and is he first ? " + first +
                "\n";
    }

    public static class PlayerBuilder {
        private String name = "player";
        private int score = 0;
        private final Field sign;
        private boolean first = true;

        public PlayerBuilder(Field sign) {
            this.sign = sign;
        }

        public PlayerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder score(int score) {
            this.score = score;
            return this;
        }


        public PlayerBuilder first(boolean first) {
            this.first = first;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
}
