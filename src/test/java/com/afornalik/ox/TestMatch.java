package com.afornalik.ox;

import com.afornalik.ox.view.UIExtended;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class TestMatch {

    private static final Board BOARD_THREE = new Board(3, 3);
    private static final Player PLAYER_1 = new Player.PlayerBuilder(Field.O).name("name1").first(false).score(0).build();
    private static final Player PLAYER_2 = new Player.PlayerBuilder(Field.X).name("name2").first(true).score(0).build();

    @Test()
    public void shouldAllFieldBeMarked() throws OutOfBoardException {
        //given
        UIExtended uiConsole = Mockito.mock(UIExtended.class);
        Mockito.when(uiConsole.readNumber()).thenReturn(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Players players = new Players(List.of(PLAYER_1,PLAYER_2));
        Match match = new Match(uiConsole, new Board(3, 3), players, null);

        //when
        Board result = match.makeATurn(0);
        fillBoard();

        //then
        assertThat(result.receiveBoardField(0)).isEqualTo(BOARD_THREE.receiveBoardField(0));
        assertThat(result.receiveBoardField(1)).isEqualTo(BOARD_THREE.receiveBoardField(1));
        assertThat(result.receiveBoardField(2)).isEqualTo(BOARD_THREE.receiveBoardField(2));
        assertThat(result.receiveBoardField(3)).isEqualTo(BOARD_THREE.receiveBoardField(3));
        assertThat(result.receiveBoardField(4)).isEqualTo(BOARD_THREE.receiveBoardField(4));
        assertThat(result.receiveBoardField(5)).isEqualTo(BOARD_THREE.receiveBoardField(5));
        assertThat(result.receiveBoardField(6)).isEqualTo(BOARD_THREE.receiveBoardField(6));
        assertThat(result.receiveBoardField(7)).isEqualTo(BOARD_THREE.receiveBoardField(7));
        assertThat(result.receiveBoardField(8)).isEqualTo(BOARD_THREE.receiveBoardField(8));
        assertThat(result.isAllFieldTaken()).isEqualTo(true);
    }


    private void fillBoard() throws OutOfBoardException {
        BOARD_THREE.insertBoardField(0, Field.X);
        BOARD_THREE.insertBoardField(1, Field.O);
        BOARD_THREE.insertBoardField(2, Field.X);
        BOARD_THREE.insertBoardField(3, Field.O);
        BOARD_THREE.insertBoardField(4, Field.X);
        BOARD_THREE.insertBoardField(5, Field.O);
        BOARD_THREE.insertBoardField(6, Field.X);
        BOARD_THREE.insertBoardField(7, Field.O);
        BOARD_THREE.insertBoardField(8, Field.X);
    }

}
