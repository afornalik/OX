package com.afornalik.ox.checker;

import com.afornalik.ox.Board;
import com.afornalik.ox.Field;
import com.afornalik.ox.OutOfBoardException;

class CheckVertically implements BoardChecker {

    private final Board board;
    private final int conditionLength;
    private int tempLength = 1;

    CheckVertically(Board board) {
        this.board = board;
        this.conditionLength = board.getCondition();
    }

    @Override
    public boolean check(int location, Field field) {
        tempLength = 1;
        checkTempLengthUp(location, field);
        checkTempLengthDown(location, field);
        return tempLength >= conditionLength;
    }

    private void checkTempLengthDown(int location, Field field) {
        Field tempStatusUp = Field.EMPTY;
        boolean leftFlag = true;
        for (int range = 1; range < conditionLength; range++) {

            if (leftFlag && (location - (range * board.getBorderSize())) >= 0) {
                try {
                    tempStatusUp = board.receiveField(location - (range * board.getBorderSize()));
                } catch (OutOfBoardException e) {
                    leftFlag = false;
                }
                if (tempStatusUp.equals(field)) {
                    tempLength++;
                } else {
                    leftFlag = false;
                }
            }
        }
    }

    private void checkTempLengthUp(int location, Field field) {
        Field tempStatusDown = Field.EMPTY;
        boolean rightFlag = true;
        for (int range = 1; range < conditionLength; range++) {
            if (rightFlag && (location + (range * board.getBorderSize()) < (board.getBorderSize() * board.getBorderSize()))) {
                try {
                    tempStatusDown = board.receiveField(location + (range * board.getBorderSize()));
                } catch (OutOfBoardException e) {
                    rightFlag = false;
                }
                if (tempStatusDown.equals(field)) {
                    tempLength++;
                } else {
                    rightFlag = false;
                }
            }

        }
    }


}
