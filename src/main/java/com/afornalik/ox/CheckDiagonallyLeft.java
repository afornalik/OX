package com.afornalik.ox;

public class CheckDiagonallyLeft implements BoardChecker {
    private final Board board;
    private final int conditionLength;
    private int tempLength = 1;

    CheckDiagonallyLeft(Board board) {
        this.board = board;
        this.conditionLength = board.getCondition();
    }

    @Override
    public boolean check(int location, Field field)  {
        tempLength = 1;
        checkTempLengthLeftUp(location, field);
        checkTempLengthRightDown(location, field);
        return tempLength >= conditionLength;
    }

    private void checkTempLengthRightDown(int location, Field field) {
        Field tempStatusLeftUp = Field.EMPTY;
        boolean leftFlag = true;
        for (int range = 1; range < conditionLength; range++) {

            if (leftFlag && ((location - (range * board.getBorderSize())) - range) >= 0) {
                try {
                    tempStatusLeftUp = board.receiveField((location - (range * board.getBorderSize())) - range);
                } catch (OutOfBoardException e) {
                    leftFlag = false;
                }
                if (tempStatusLeftUp.equals(field)) {
                    tempLength++;
                } else {
                    leftFlag = false;
                }
            }
        }
    }

    private void checkTempLengthLeftUp(int location, Field field) {
        Field tempStatusRightDown = Field.EMPTY;
        boolean rightFlag = true;
        for (int range = 1; range < conditionLength; range++) {
            if (rightFlag && (location + ((range * board.getBorderSize()) + range) < (board.getBorderSize() * board.getBorderSize()))) {
                try {
                    tempStatusRightDown = board.receiveField((location + (range * board.getBorderSize())) + range);
                } catch (OutOfBoardException e) {
                    rightFlag = false;
                }
                if (tempStatusRightDown.equals(field)) {
                    tempLength++;
                } else {
                    rightFlag = false;
                }
            }

        }
    }
}
