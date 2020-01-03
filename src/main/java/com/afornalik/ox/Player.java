package com.afornalik.ox;

class Player {

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

    int getScore() {
        return score;
    }

    String getName() {
        return name;
    }

    Field getSign() {
        return sign;
    }

    boolean isFirst() {
        return first;
    }


    @Override
    public String toString() {
        return "Player " +
                "name is " + name +
                " ,has score = " + score +
                " ,use sign = " + sign +
                " , first ? " + first +
                "\n";
    }

    static class PlayerBuilder {
        private String name = "player";
        private int score = 0;
        private final Field sign;
        private boolean first = true;

        PlayerBuilder(Field sign) {
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
