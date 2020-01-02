package com.afornalik.ox.model.player;

import com.afornalik.ox.Player;
import com.afornalik.ox.PlayerContainer;
import com.afornalik.ox.Field;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;


@Test
public class TestPlayerContainer {

    private static final Player PLAYER1 = new Player.PlayerBuilder(Field.O)
            .name("Kasia")
            .score(0)
            .first(true)
            .build();

    private static final Player PLAYER2 = new Player.PlayerBuilder(Field.X)
            .name("Gosia")
            .score(0)
            .first(false)
            .build();

    public void shouldCreateBothPlayers() {
        //given
        Map<String, Object> playerInfo1 = Map.of(
                "Field", Field.O,
                "name", "Kasia",
                "score", 0,
                "first", true);
        Map<String, Object> playerInfo2 = Map.of(
                "Field", Field.X,
                "name", "Gosia",
                "score", 0,
                "first", false);

        PlayerContainer playerContainer = new PlayerContainer();

        //when
        playerContainer.createPlayer(playerInfo1);
        playerContainer.createPlayer(playerInfo2);

        //then
        Assertions.assertThat(playerContainer.getPlayer(0)).isEqualTo(PLAYER1.toString());
        Assertions.assertThat(playerContainer.getPlayer(1)).isEqualTo(PLAYER2.toString());

    }

}
