package com.afornalik.ox;


import java.util.Objects;

class Player implements Comparable<Player> {

    private final String name;
    private int score;
    private final Field sign;
    private int order;

    private Player(String name, int score, Field sign, int order) {
        this.name = name;
        this.score = score;
        this.sign = sign;
        this.order = order;
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

    int getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "Player " +
                "name is " + name +
                " ,has score = " + score +
                " ,use sign = " + sign +
                " , order ? " + order +
                "\n";
    }

    @Override
    public int compareTo(Player o) {
        return this.getOrder() - o.getOrder();
    }


    static class PlayerBuilder {
        private String name = "player";
        private int score = 0;
        private final Field sign;
        private int order;

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


        PlayerBuilder order(int order) {
            this.order = order;
            return this;
        }

        Player build() {
            return new Player(this.name, this.score, this.sign, this.order);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return score == player.score &&
                order == player.order &&
                Objects.equals(name, player.name) &&
                sign == player.sign;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, sign, order);
    }
}
