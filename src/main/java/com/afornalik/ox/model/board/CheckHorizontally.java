package com.afornalik.ox.model.board;

public class CheckHorizontally implements BoardChecker {

    private final Board board;
    private final int conditionLength;

    public CheckHorizontally(Board board, int conditionLength) {
        this.board = board;
        this.conditionLength = conditionLength;
    }

    //in progress - not work yet
    @Override
    public boolean check(int location, FieldStatus fieldStatus) throws OutOfBoardException {
        int tempLength = 1;
        boolean leftFlag = true;
        boolean rightFlag = true;
        FieldStatus tempStatus;


        for (int range = 1; range < conditionLength; range++) {
            //left site
            if (((location + 1) - range) % board.getBorderSize() == 0) {
                leftFlag = false;
            }
            if (leftFlag && (location - range) >= 0) {
                tempStatus = board.receiveBoardField(location - range);

                if (tempStatus.equals(fieldStatus)) {
                    //increment length
                    tempLength++;
                } else {
                    leftFlag = false;
                }
            }
            //right site
            if (rightFlag && (location + range) < (board.getBorderSize() * board.getBorderSize())) {
                tempStatus = board.receiveBoardField(location + range);

                if (tempStatus.equals(fieldStatus)) {
                    //increment length
                    tempLength++;
                } else {
                    rightFlag = false;
                }
            }

            if (((location) + range) % board.getBorderSize() == 0) {
                rightFlag = false;
            }

            //check condition
            if (tempLength >= conditionLength) {
                return true;
            }
        }
        return false;
    }
}
