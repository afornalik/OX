package com.afornalik.ox.controller;

import com.afornalik.ox.model.board.FieldStatus;
import com.afornalik.ox.model.player.Player;
import com.afornalik.ox.model.player.PlayerContainer;
import com.afornalik.ox.view.print.UIConsoleOperations;
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
        UIConsoleOperations uiConsole = Mockito.mock(UIConsoleOperations.class);
        Mockito.when(uiConsole.read()).thenReturn("Kasia","o","Kasia","o","1");
        PlayerController playerController = new PlayerController(uiConsole);

        //when
        PlayerContainer result = playerController.createTwoPlayer();

        //then
        Assertions.assertThat(result.getPlayer(0)).isEqualTo(PLAYER1.toString());
    }
}
