package com.afornalik.ox;

/**
 * Responsible for check the condition of the game.
 */

@FunctionalInterface
interface BoardChecker {

    /**
     *  Check if the last putting mark fulfill the condition of winning the game.
     *  If yes then return true, else return false, OutOfBoardException can be thrown.
     *
     * @param location int location of putted sign.
     * @param field Field enum define type of sign.
     * @return boolean if condition is true then return true, else return false.
     * @throws OutOfBoardException throw if location is out of range.
     */
    boolean check(int location, Field field) throws OutOfBoardException;
}
