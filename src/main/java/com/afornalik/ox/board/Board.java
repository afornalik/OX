package com.afornalik.ox.board;

import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

/**
 * Board class is responsible for hold information about board,
 * also this class make some basic operations.
 *
 * @author Andrzej Fornalik
 * @version 0.1
 * @since 2019-12-20
 */
public class Board {
    private final Map<Integer, FieldStatus> boardFields = new TreeMap<>();
    private final int borderSize;
    private final BigInteger maxValue;

    /**
     * Default constructor to generate board.
     *
     * @param borderSize describe size of board. Prefer value are between 3 and 50.
     */
    public Board(int borderSize) {
        this.borderSize = borderSize;
        this.maxValue = new BigInteger(String.valueOf(borderSize))
                .multiply(BigInteger.valueOf(borderSize))
                .subtract(BigInteger.ONE);
    }

    /**
     * Method return board size.
     *
     * @return int This method return board size
     */
    public int getBorderSize() {
        return borderSize;
    }

    /**
     * Method to insert appropriate value into board.
     *
     * @param axisX int This is horizontal coordinate of field
     * @param axisY int This is vertical coordinate of field
     * @param fieldStatus  FieldStatus This is enum value which determine what symbol will be inserted
     * @throws OutOfBoardException throw if index is lower than 0 and higher than maxValue ( borderSize * borderSize )
     * @throws OverrideFieldException throw when field is already taken by another mark
     */
    public void insertBoardField(int axisX,int axisY, FieldStatus fieldStatus) throws OutOfBoardException,OverrideFieldException {
        if(axisX < borderSize && axisY < borderSize) {
            int indexOfField = convertToIndex(axisX, axisY);
            if (checkIndexRange(indexOfField)) {
                if (receiveBoardField(indexOfField) == FieldStatus.EMPTY) {
                    boardFields.put(indexOfField, fieldStatus);
                } else {
                    throw new OverrideFieldException(" Field is already taken.");
                }
            }
        }
    }

    /**
     * Method to receive value from board.
     *
     * @param indexOfField int This is index of field from which value will be taken.
     * @return FieldStatus This method return enum value corresponding to x or o.
     * @throws OutOfBoardException throw if index is lower than 0 and higher than maxValue ( borderSize * borderSize )
     */
    public FieldStatus receiveBoardField(int indexOfField) throws OutOfBoardException {
        if (checkIndexRange(indexOfField)) {
            if (boardFields.get(indexOfField) != null) {
                return boardFields.get(indexOfField);
            }
        }
        return FieldStatus.EMPTY;
    }

    /**
     * Method return number empty field in the board.
     *
     * @return int number of empty field.
     */
    public int receiveNumberOfEmptyFields() {
        return (maxValue.intValue() + 1) - boardFields.size();
    }

    private boolean checkIndexRange(int indexOfField) throws OutOfBoardException {
        int minValue = 0;
        if (indexOfField < minValue || indexOfField > maxValue.intValue()) {
            throw new OutOfBoardException("Out of board - min value is : " + minValue + ", and max value is : " + maxValue.toString());
        }
        return true;
    }

    private int convertToIndex(int axisX, int axisY) {
        return  ((axisY-1)*borderSize)+(axisX-1);
    }
}
