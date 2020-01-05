package com.afornalik.ox;

import com.afornalik.ox.view.UI;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class TestMatch {

    private static final Board BOARD_THREE = new Board(3, 3);
    private static final Player PLAYER_1 = new Player.PlayerBuilder(Field.O).name("name1").order(1).score(0).build();
    private static final Player PLAYER_2 = new Player.PlayerBuilder(Field.X).name("name2").order(0).score(0).build();

    @Test()
    public void shouldAllFieldBeMarked() throws OutOfBoardException {
        //given
        UI uiConsole = Mockito.mock(UI.class);
        Mockito.when(uiConsole.readNumber()).thenReturn(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Player> players = (List.of(PLAYER_2, PLAYER_1));
        Match match = new Match(uiConsole, new Board(3, 3), players, null);

        //when
        Board result = match.nextRound(0);
        fillBoard();

        //then
        assertThat(result.receiveField(0)).isEqualTo(BOARD_THREE.receiveField(0));
        assertThat(result.receiveField(1)).isEqualTo(BOARD_THREE.receiveField(1));
        assertThat(result.receiveField(2)).isEqualTo(BOARD_THREE.receiveField(2));
        assertThat(result.receiveField(3)).isEqualTo(BOARD_THREE.receiveField(3));
        assertThat(result.receiveField(4)).isEqualTo(BOARD_THREE.receiveField(4));
        assertThat(result.receiveField(5)).isEqualTo(BOARD_THREE.receiveField(5));
        assertThat(result.receiveField(6)).isEqualTo(BOARD_THREE.receiveField(6));
        assertThat(result.receiveField(7)).isEqualTo(BOARD_THREE.receiveField(7));
        assertThat(result.receiveField(8)).isEqualTo(BOARD_THREE.receiveField(8));
        assertThat(result.isAllFieldTaken()).isEqualTo(true);
    }


    private void fillBoard() throws OutOfBoardException {
        BOARD_THREE.insertField(0, Field.X);
        BOARD_THREE.insertField(1, Field.O);
        BOARD_THREE.insertField(2, Field.X);
        BOARD_THREE.insertField(3, Field.O);
        BOARD_THREE.insertField(4, Field.X);
        BOARD_THREE.insertField(5, Field.O);
        BOARD_THREE.insertField(6, Field.X);
        BOARD_THREE.insertField(7, Field.O);
        BOARD_THREE.insertField(8, Field.X);
    }

}
