package com.afornalik.ox;


import java.util.Objects;

class Player implements Comparable<Player> {

    private final String name;
    private final int score;
    private final Field sign;
    private final int sequence;

    private Player(String name, int score, Field sign, int sequence) {
        this.name = name;
        this.score = score;
        this.sign = sign;
        this.sequence = sequence;
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

    int getSequence() {
        return sequence;
    }

    @Override
    public String toString() {
        return "Player " +
                "name is " + name +
                " ,has score = " + score +
                " ,use sign = " + sign +
                " , sequence ? " + sequence +
                "\n";
    }

    @Override
    public int compareTo(Player o) {
        return this.getSequence() - o.getSequence();
    }


    static class PlayerBuilder {
        private String name = "player";
        private int score = 0;
        private final Field sign;
        private int sequence;

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


        PlayerBuilder sequence(int sequence) {
            this.sequence = sequence;
            return this;
        }

        Player build() {
            return new Player(this.name, this.score, this.sign, this.sequence);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return score == player.score &&
                sequence == player.sequence &&
                Objects.equals(name, player.name) &&
                sign == player.sign;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, sign, sequence);
    }
}
