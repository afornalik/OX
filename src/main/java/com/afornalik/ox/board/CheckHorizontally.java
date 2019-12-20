package com.afornalik.ox.board;

public class CheckHorizontally implements CheckBoard {

    public final Board board;
    public final int conditionLength;

    public CheckHorizontally(Board board, int conditionLength) {
        this.board = board;
        this.conditionLength = conditionLength;
    }

    @Override
    public boolean check(int location, FieldStatus fieldStatus) throws OutOfBoardException {
        int tempLength = 1;
        boolean leftFlag = true;
        boolean rightFlag = true;
        for (int i = 1; i <= conditionLength; i++) {
            if(location-i % board.getBound() >= 0) {
                BoardField leftField = board.receiveBoardField(location - i);
                if (leftField != null && (leftFlag)) {
                    if (leftField.showStatus() == fieldStatus) {
                        tempLength++;
                    }
                } else {
                    leftFlag = false;
                }
            }else {
                leftFlag= false;
                }
            BoardField rightField = board.receiveBoardField(location + i);
            if (rightField != null && (rightFlag)) {
                if (rightField.showStatus() == fieldStatus) {
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
