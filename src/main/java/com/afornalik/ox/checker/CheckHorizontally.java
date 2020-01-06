package com.afornalik.ox.checker;

import com.afornalik.ox.Board;
import com.afornalik.ox.Field;
import com.afornalik.ox.OutOfBoardException;

class CheckHorizontally implements BoardChecker {

    private final Board board;
    private final int conditionLength;
    private int tempLength;

    CheckHorizontally(Board board) {
        this.board = board;
        this.conditionLength = board.getCondition();
    }


    @Override
    public boolean check(int location, Field field) {
        tempLength = 1;
        checkTempLengthLeft(location, field);
        checkTempLengthRight(location, field);
        return tempLength >= conditionLength;
    }

    private void checkTempLengthLeft(int location, Field field) {
        Field tempStatusLeft = Field.EMPTY;
        boolean leftFlag = true;
        for (int range = 1; range < conditionLength; range++) {
            leftFlag = isEndOfLine(leftFlag, (location + 1) - range);
            if (leftFlag && (location - range) >= 0) {
                try {
                    tempStatusLeft = board.receiveField(location - range);
                } catch (OutOfBoardException e) {
                    leftFlag = false;
                }
                if (tempStatusLeft.equals(field)) {
                    tempLength++;
                } else {
                    leftFlag = false;
                }
            }
        }
    }

    private void checkTempLengthRight(int location, Field field) {
        Field tempStatusRight = Field.EMPTY;
        boolean rightFlag = true;
        for (int range = 1; range < conditionLength; range++) {
            if (rightFlag && (location + range) < (board.getBorderSize() * board.getBorderSize())) {
                try {
                    tempStatusRight = board.receiveField(location + range);
                } catch (OutOfBoardException e) {
                    e.printStackTrace();
                }
                if (tempStatusRight.equals(field)) {
                    tempLength++;
                } else {
                    rightFlag = false;
                }
            }
            rightFlag = isEndOfLineRight(rightFlag, (location) + range);
        }
    }

    private boolean isEndOfLine(boolean rightFlag, int i) {
        if ((i) % board.getBorderSize() == 0) {
            rightFlag = false;
        }
        return rightFlag;
    }

    private boolean isEndOfLineRight(boolean rightFlag, int i) {
        if ((i) % (board.getBorderSize()) == 0) {
            rightFlag = false;
        }
        return rightFlag;
    }
}
