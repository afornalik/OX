package com.afornalik.ox;

import com.afornalik.ox.view.UISimple;
import org.assertj.core.api.Assertions;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Test
public class TestConfiguration {

    private static final Player PLAYER1 = new Player.PlayerBuilder(Field.O)
            .name("Kasia")
            .score(0)
            .first(true)
            .build();

    public void shouldCreateTwoPlayers() {
        //given
        UISimple uiConsole = Mockito.mock(UISimple.class);
        Mockito.when(uiConsole.read()).thenReturn("Kasia", "o", "Kasia", "x", "1");
        Configuration configuration = new Configuration(uiConsole, null);

        //when
        PlayerContainer result = configuration.createTwoPlayer();

        //then
        Assertions.assertThat(result.getPlayer(0)).isEqualTo(PLAYER1.toString());
    }

    public void shouldGreetUser() {
        //given
        UISimple uiSimple = Mockito.mock(UISimple.class);
        Configuration headController = new Configuration(uiSimple, null);

        //when
        headController.greetUser();

        //then
        verify(uiSimple, times(1)).print(any());
    }

    public void shouldCreateBoard() {
        //given
        UISimple uiOperations = Mockito.mock(UISimple.class);
        BDDMockito.when(uiOperations.readNumber()).thenReturn(3);
        Configuration boardController = new Configuration(uiOperations, null);

        //when
        Board result = boardController.createBoard();

        //then
        Assertions.assertThat(result).isEqualTo(new Board(3, 3));
    }
}
