package com.afornalik.ox.model.board;

@FunctionalInterface
public interface CheckBoard {

    boolean check(int location, FieldStatus fieldStatus) throws OutOfBoardException;
}
