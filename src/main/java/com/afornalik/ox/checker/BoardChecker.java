package com.afornalik.ox.checker;

import com.afornalik.ox.Field;

/**
 * Responsible for check the condition of the game.
 */

@FunctionalInterface
interface BoardChecker {

    /**
     * Check if the last putting mark fulfill the condition of winning the game.
     * If yes then return true, else return false, OutOfBoardException can be thrown.
     *
     * @param location int location of put sign.
     * @param field    Field enum define type of sign.
     * @return boolean result of checking the condition.
     */
    boolean check(int location, Field field);
}
