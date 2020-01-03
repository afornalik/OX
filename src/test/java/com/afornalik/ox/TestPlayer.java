package com.afornalik.ox;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

@Test
public class TestPlayer {


    public void shouldBuildPlayer() {
        //when
        Player player = new Player.PlayerBuilder(Field.O)
                .name("player")
                .score(0)
                .first(true)
                .build();

        //then
        assertThat(player.getName()).isEqualTo("player");
        assertThat(player.getScore()).isEqualTo(0);
        assertThat(player.getSign()).isEqualTo(Field.O);
        assertThat(player.isFirst()).isEqualTo(true);
    }

}
