package com.afornalik.ox;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ArgumentConverter {

    private final List<String> args;

    ArgumentConverter(String[] args) {
        this.args = Arrays.asList(args);
    }

    Map<String,String> convertToPlayers() {
        Map<String, String> players = new HashMap<>();
        players.put("name",args.get(0));
        players.put("Field",args.get(1));
        players.put("name2",args.get(2));
        players.put("first",args.get(3));

        /*players.put("name",args.get(0));
        if(args.get(1).equalsIgnoreCase("x")) {
            players.put("Field", Field.X);
        }else if(args.get(1).equalsIgnoreCase("o")){
            players.put("Field",Field.O);
        }
        if(args.get(2).equals("1")) {
            players.put("first",true);
        }else if*/

        return players;
    }
        private Player convertMapToPlayer(Map<String, Object> playerInfo) {
            return new Player.PlayerBuilder((Field) playerInfo.get("Field"))
                    .name((String) playerInfo.get("name"))
                    .score((int) playerInfo.get("score"))
                    .first((boolean) playerInfo.get("first"))
                    .build();

    }
}
