package com.afornalik.ox;

import com.afornalik.ox.view.UI;
import org.assertj.core.api.Assertions;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Test
public class TestGameBuilder {

    public void shouldCreateTwoPlayers() {
        //given
        Player PLAYER1 = new Player.PlayerBuilder(Field.O)
                .name("Kasia")
                .score(0)
                .sequence(0)
                .build();
        UI uiConsole = Mockito.mock(UI.class);
        Mockito.when(uiConsole.read()).thenReturn("Kasia", "o", "Kasia", "x", "1");
        GameBuilder gameBuilder = new GameBuilder(uiConsole);

        //when
        List<Player> result = gameBuilder.createTwoPlayer();

        //then
        Assertions.assertThat(result.get(0).toString()).isEqualTo(PLAYER1.toString());
    }

    public void shouldGreetUser() {
        //given
        UI ui = Mockito.mock(UI.class);
        GameBuilder headController = new GameBuilder(ui);

        //when
        headController.greetUser();

        //then
        verify(ui, times(1)).print(any());
    }

    public void shouldCreateBoard() {
        //given
        UI uiOperations = Mockito.mock(UI.class);
        BDDMockito.when(uiOperations.readNumber()).thenReturn(3);
        GameBuilder boardController = new GameBuilder(uiOperations);

        //when
        Board result = boardController.createBoard();

        //then
        Assertions.assertThat(result).isEqualTo(new Board(3, 3));
    }
}
