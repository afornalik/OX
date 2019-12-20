package com.afornalik.ox.board;

@FunctionalInterface
public interface CheckBoard {

    boolean check(int location, FieldStatus fieldStatus) throws OutOfBoardException;
}
