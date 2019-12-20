package com.afornalik.ox.board;

import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

public class Board {

    private Map<Integer, BoardField> boardFields = new TreeMap<>();
    private final int bound;
    private final BigInteger maxValue;
    private final int minValue = 0;

    public Board(int bound) {
        this.bound = bound;
        this.maxValue= new BigInteger(String.valueOf(bound))
                .multiply(BigInteger.valueOf(bound))
                .subtract(BigInteger.ONE);
    }

    public int getBound() {
        return bound;
    }



    public void insertMark(int indexOfField, FieldStatus fieldStatusX) {

    }


    BoardField receiveBoardField(int i) throws OutOfBoardException {
        if (i < minValue || i > maxValue.intValue()) {
            throw new OutOfBoardException("Out of board - min value is : " +minValue+", and max value is : "+maxValue.toString());
        } else if (boardFields.get(i) == null) {
            return null;
        }
        return boardFields.get(1);
    }

}
