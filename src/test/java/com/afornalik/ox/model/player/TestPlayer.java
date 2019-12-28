package com.afornalik.ox.model.player;

import com.afornalik.ox.model.board.FieldStatus;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

@Test
public class TestPlayer {


    public void shouldCreatePlayerUsingBuilder() {
        //when
        Player player = new Player.PlayerBuilder(FieldStatus.O)
                .name("player")
                .score(0)
                .first(true)
                .build();

        //then
        assertThat(player.getName()).isEqualTo("player");
        assertThat(player.getScore()).isEqualTo(0);
        assertThat(player.getSign()).isEqualTo(FieldStatus.EMPTY);
        assertThat(player.isFirst()).isEqualTo(true);
    }

}
