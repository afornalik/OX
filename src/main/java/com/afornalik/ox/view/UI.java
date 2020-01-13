package com.afornalik.ox.view;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Class responsible for communication with a user.
 * This implementation cover basic console interface.
 *
 * @author Andrzej Fornalik
 */

public class UI {

    private final List<String> allLines = Collections.emptyList();
    private final Scanner scanner;

    /**
     * Default constructor scanner need to be specified.
     *
     * @param scanner object hold input from a user.
     */
    public UI(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Method print on the console given string.
     *
     * @param string String to be printed out by System.out.print() method
     */
    public void print(String string) {
        System.out.print(string);
    }

    /**
     * Method read String from user and parse it to int.
     * Inside is a loop which wait for number to be input.
     * NumberFormatException is coughed inside that loop.
     *
     * @return int value
     */
    public int readNumber() {
        String stringToParse;
        int integerVal;
        do {
            stringToParse = scanner.next();
            try {
                integerVal = Integer.parseInt(stringToParse);
                break;
            } catch (NumberFormatException e) {
                this.print(" insert number ");
            }
        } while (true);
        return integerVal;
    }

    /**
     * Simple read method which boxing scanner.next() method
     *
     * @return String value read by scanner
     */
    public String read() {
        return scanner.next();
    }

    public boolean getAllLines() {
        return false;
    }
}
