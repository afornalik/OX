package com.afornalik.ox.model.board;

public class CheckHorizontally implements BoardChecker {

    private final Board board;
    private final int conditionLength;

    public CheckHorizontally(Board board, int conditionLength) {
        this.board = board;
        this.conditionLength = conditionLength;
    }

    @Override
    public boolean check(int location, FieldStatus fieldStatus) throws OutOfBoardException {
        int tempLength = 1;
        tempLength = getTempLengthLeft(location, fieldStatus, tempLength);
        tempLength = getTempLengthRight(location, fieldStatus, tempLength);
        if (tempLength >= conditionLength) return true;
        return false;
    }

    private int getTempLengthLeft(int location, FieldStatus fieldStatus, int tempLength) throws OutOfBoardException {
        FieldStatus tempStatusLeft;
        boolean leftFlag = true;
        for (int range = 1; range < conditionLength; range++) {
            leftFlag = isEndOfLine(leftFlag, (location + 1) - range);
            if (leftFlag && (location - range) >= 0) {
                tempStatusLeft = board.receiveBoardField(location - range);
                if (tempStatusLeft.equals(fieldStatus)) {
                    //increment length
                    tempLength++;
                } else {
                    leftFlag = false;
                }
            }
        }
        return tempLength;
    }

    private int getTempLengthRight(int location, FieldStatus fieldStatus, int tempLength) throws OutOfBoardException {
        FieldStatus tempStatusRight;
        boolean rightFlag = true;
        for (int range = 1; range < conditionLength; range++) {
            if (rightFlag && (location + range) < (board.getBorderSize() * board.getBorderSize())) {
                tempStatusRight = board.receiveBoardField(location + range);
                if (tempStatusRight.equals(fieldStatus)) {
                    tempLength++;
                } else {
                    rightFlag = false;
                }
            }
            rightFlag = isEndOfLine(rightFlag, (location) + range);
        }
        return tempLength;
    }

    private boolean isEndOfLine(boolean rightFlag, int i) {
        if ((i) % board.getBorderSize() == 0) {
            rightFlag = false;
        }
        return rightFlag;
    }
}
