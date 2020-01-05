package com.afornalik.ox;

public class CheckDiagonallyRight implements BoardChecker {

    private final Board board;
    private final int conditionLength;
    private int tempLength = 1;

    CheckDiagonallyRight(Board board) {
        this.board = board;
        this.conditionLength = board.getCondition();
    }

    @Override
    public boolean check(int location, Field field) {
        tempLength = 1;
        checkTempLengthLeftDown(location, field);
        checkTempLengthRightUp(location, field);
        return tempLength >= conditionLength;
    }

    private void checkTempLengthRightUp(int location, Field field) {
        Field tempStatusLeftDown = Field.EMPTY;
        boolean leftFlag = true;
        for (int range = 1; range < conditionLength; range++) {

            if (leftFlag && ((location - (range * board.getBorderSize())) + range) >= 0) {
                try {
                    tempStatusLeftDown = board.receiveField((location - (range * board.getBorderSize())) + range);
                } catch (OutOfBoardException e) {
                    leftFlag = false;
                }
                if (tempStatusLeftDown.equals(field)) {
                    tempLength++;
                } else {
                    leftFlag = false;
                }
            }
        }
    }

    private void checkTempLengthLeftDown(int location, Field field) {
        Field tempStatusRightUp = Field.EMPTY;
        boolean rightFlag = true;
        for (int range = 1; range < conditionLength; range++) {
            if (rightFlag && (location + ((range * board.getBorderSize()) - range) < (board.getBorderSize() * board.getBorderSize()))) {
                try {
                    tempStatusRightUp = board.receiveField((location + (range * board.getBorderSize())) - range);
                } catch (OutOfBoardException e) {
                    rightFlag = false;
                }
                if (tempStatusRightUp.equals(field)) {
                    tempLength++;
                } else {
                    rightFlag = false;
                }
            }

        }
    }
}


