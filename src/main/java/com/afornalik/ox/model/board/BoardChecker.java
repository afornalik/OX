package com.afornalik.ox.model.board;

@FunctionalInterface
interface BoardChecker {

    boolean check(int location, FieldStatus fieldStatus) throws OutOfBoardException;
}
