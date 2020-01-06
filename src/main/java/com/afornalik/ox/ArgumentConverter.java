package com.afornalik.ox;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ArgumentConverter {

    private final List<String> args;

    ArgumentConverter(String[] args) {
        this.args = Arrays.asList(args);
    }

    Map<String, String> convertToConfiguration() {
        if (args.size() >0) {
            Map<String, String> configuration = new HashMap<>();
            configuration.put("name", args.get(0));
            configuration.put("Field", args.get(1));
            configuration.put("first", args.get(2));
            configuration.put("name2", args.get(3));
            configuration.put("size", args.get(4));
            configuration.put("condition", args.get(5));
            return configuration;
        }
        return null;
    }

    List<Integer> convertToMove() {
        if (args.size() >6) {
            List<String> tempList = args.subList(6,args.size());
            return tempList.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
        return null;
    }

}