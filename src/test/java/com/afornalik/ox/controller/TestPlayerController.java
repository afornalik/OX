package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.FieldStatus;
import com.afornalik.ox.model.player.Player;
import com.afornalik.ox.view.UIConsole;
import org.assertj.core.api.Assertions;
import org.mockito.Mockito;
import org.testng.annotations.Test;

@Test
public class TestPlayerController {

    private static final Player PLAYER1 =  new Player.PlayerBuilder(FieldStatus.O)
            .name("Kasia")
            .score(0)
            .first(true)
            .build();

    public void shouldCreateTwoPlayers() {
        //given
        UIConsole uiConsole = Mockito.mock(UIConsole.class);
        Mockito.when(uiConsole.read()).thenReturn("Kasia","o","y");
        PlayerController playerController = new PlayerController(uiConsole);

        //when
        String result = playerController.createPlayer();

        //then
        Assertions.assertThat(result).isEqualTo(PLAYER1.toString());
    }
}
