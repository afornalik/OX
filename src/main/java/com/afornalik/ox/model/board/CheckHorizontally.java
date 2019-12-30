package com.afornalik.ox.model.board;

public class CheckHorizontally implements BoardChecker{

    public final Board board;
    public final int conditionLength;

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
        for (int i = 1; i <= conditionLength; i++) {
            if(location-i % board.getBorderSize() >= 0) {
                FieldStatus leftField = board.receiveBoardField(location - i);
                if (leftField != null && (leftFlag)) {
                    if (leftField == fieldStatus) {
                        tempLength++;
                    }
                } else {
                    leftFlag = false;
                }
            }else {
                leftFlag= false;
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
            if (!leftFlag && !rightFlag){
                return false;
            }
        }
        return false;
    }
}
