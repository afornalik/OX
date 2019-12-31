package com.afornalik.ox.model.board;

public class CheckHorizontally implements BoardChecker {

    private final Board board;
    private final int conditionLength;
    private static final int HALF = 2;

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
        FieldStatus tempStatus = FieldStatus.EMPTY;

        for (int range = 1; range < (conditionLength + 1 / HALF); range++) {
            //left site
            if (leftFlag && (location - range) > 0) {
                tempStatus = board.receiveBoardField(location - range);

                if (tempStatus.equals(fieldStatus)) {
                    //increment length
                    tempLength++;
                } else {
                    leftFlag = false;
                }
            }
            //right site
            if (rightFlag && (location + range) < board.getBorderSize()) {
                tempStatus = board.receiveBoardField(location + range);


                if (tempStatus.equals(fieldStatus)) {
                    //increment length
                    tempLength++;
                } else {
                    rightFlag = false;
                }
            }


            //check condition
            if (tempLength >= conditionLength) {
                return true;
            }
        }
        return false;
























       /* for (int i = 1; i <= conditionLength; i++) {
            if (location - i % board.getBorderSize() >= 0) {
                FieldStatus leftField = board.receiveBoardField(location - i);
                if (leftField != null && (leftFlag)) {
                    if (leftField == fieldStatus) {
                        tempLength++;
                    }
                } else {
                    leftFlag = false;
                }
            } else {
                leftFlag = false;
            }

            FieldStatus rightField = board.receiveBoardField(location + i);

            if (rightField != null && (rightFlag)) {
                if (rightField == fieldStatus) {
                    tempLength++;
                }
            } else {
                rightFlag = false;
            }
            if (tempLength >= conditionLength) {
                return true;
            }
            if (!leftFlag && !rightFlag) {
                return false;
            }
        }
        return false;*/

    }
}
