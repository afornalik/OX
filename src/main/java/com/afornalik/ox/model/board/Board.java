package com.afornalik.ox.model.board;

import java.util.Map;
import java.util.Objects;
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
    private final int maxValue;

    /**
     * Default constructor to generate board.
     *
     * @param borderSize describe size of board. Prefer value are between 3 and 50.
     */
    public Board(int borderSize) {
        this.borderSize = borderSize;
        this.maxValue = borderSize * borderSize;
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
     * @param indexOfField int This is index of field where value will be insert.
     * @param fieldStatus  FieldStatus This is enum value which determine what symbol will be inserted
     * @throws OutOfBoardException throw if index is lower than 0 and higher than maxValue ( borderSize * borderSize )
     */
    public void insertBoardField(int indexOfField, FieldStatus fieldStatus) throws OutOfBoardException {
        if (checkIndexRange(indexOfField))
            boardFields.put(indexOfField, fieldStatus);
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
    public boolean isAllFieldTaken() {
        return (maxValue - boardFields.size() == 0);
    }

    private boolean checkIndexRange(int indexOfField) throws OutOfBoardException {
        int minValue = 0;
        if (indexOfField < minValue || indexOfField > maxValue - 1) {
            throw new OutOfBoardException("Out of board - min value is : " + (minValue + 1) + ", and max value is : " + maxValue);
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return borderSize == board.borderSize &&
                Objects.equals(boardFields, board.boardFields) &&
                Objects.equals(maxValue, board.maxValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardFields, borderSize, maxValue);
    }
}
