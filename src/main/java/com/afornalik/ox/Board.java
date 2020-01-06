package com.afornalik.ox;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Board class is responsible for hold information about board,
 * also this class make some basic operations.
 *
 * @author Andrzej Fornalik
 * @since 2019-12-20
 */
public class Board {
    private final Map<Integer, Field> boardFields = new TreeMap<>();
    private final int borderSize;
    private final int maxValue;
    private final int condition;

    /**
     * Default constructor to generate board.
     *
     * @param borderSize describe size of board. Prefer value are between 3 and 50.
     * @param condition  set a number of mark in row or column to win match. If condition is
     *                   higher than borderSize than condition is set to borderSize
     */
    public Board(int borderSize, int condition) {
        this.borderSize = borderSize;
        this.maxValue = borderSize * borderSize;
        this.condition = Math.min(condition, borderSize);
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
     * @param field        Field This is enum value which determine what symbol will be inserted
     * @throws OutOfBoardException throw if index is lower than 0 and higher than maxValue ( borderSize * borderSize )
     */
    public void insertField(int indexOfField, Field field) throws OutOfBoardException {
        if (checkIndexRange(indexOfField))
            boardFields.put(indexOfField, field);
    }

    /**
     * Method to receive value from board.
     *
     * @param indexOfField int This is index of field from which value will be taken.
     * @return Field This method return enum value corresponding to x or o.
     * @throws OutOfBoardException throw if index is lower than 0 and higher than maxValue ( borderSize * borderSize )
     */
    public Field receiveField(int indexOfField) throws OutOfBoardException {
        if (checkIndexRange(indexOfField)) {
            if (boardFields.get(indexOfField) != null) {
                return boardFields.get(indexOfField);
            }
        }
        return Field.EMPTY;
    }

    /**
     * Method return number empty field in the board.
     *
     * @return int number of empty field.
     */
    boolean isAllFieldTaken() {
        return (maxValue - boardFields.size() == 0);
    }


    /**
     * Method return length of condition which need to be fulfilled to win the match.
     *
     * @return int length of winning condition
     */
    public int getCondition() {
        return condition;
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
