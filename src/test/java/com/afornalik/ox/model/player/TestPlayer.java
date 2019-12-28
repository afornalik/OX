package com.afornalik.ox.model.player;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

@Test
public class TestPlayer {

    public void shouldCreatePlayer() {
        //when
        Player player = new Player();

        //then
        assertThat(player.getScore()).isEqualTo(0);

    }
}
