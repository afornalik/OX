package com.afornalik.ox.model.board;

@FunctionalInterface
public interface BoardChecker {

    boolean check(int location, FieldStatus fieldStatus) throws OutOfBoardException;
}
