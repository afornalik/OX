package com.afornalik.ox;

class CheckHorizontally implements BoardChecker {

    private final Board board;
    private final int conditionLength;
    private int tempLength = 1;

    CheckHorizontally(Board board) {
        this.board = board;
        this.conditionLength = board.getCondition();
    }


    @Override
    public boolean check(int location, Field field) throws OutOfBoardException {
        tempLength = 1;
        getTempLengthLeft(location, field);
        getTempLengthRight(location, field);
        return tempLength >= conditionLength;
    }

    private void getTempLengthLeft(int location, Field field) throws OutOfBoardException {
        Field tempStatusLeft;
        boolean leftFlag = true;
        for (int range = 1; range < conditionLength; range++) {
            leftFlag = isEndOfLine(leftFlag, (location + 1) - range);
            if (leftFlag && (location - range) >= 0) {
                tempStatusLeft = board.receiveBoardField(location - range);
                if (tempStatusLeft.equals(field)) {
                    tempLength++;
                } else {
                    leftFlag = false;
                }
            }
        }
    }

    private void getTempLengthRight(int location, Field field) throws OutOfBoardException {
        Field tempStatusRight;
        boolean rightFlag = true;
        for (int range = 1; range < conditionLength; range++) {
            if (rightFlag && (location + range) < (board.getBorderSize() * board.getBorderSize())) {
                tempStatusRight = board.receiveBoardField(location + range);
                if (tempStatusRight.equals(field)) {
                    tempLength++;
                } else {
                    rightFlag = false;
                }
            }
            rightFlag = isEndOfLine(rightFlag, (location) + range);
        }
    }

    private boolean isEndOfLine(boolean rightFlag, int i) {
        if ((i) % board.getBorderSize() == 0) {
            rightFlag = false;
        }
        return rightFlag;
    }
}
