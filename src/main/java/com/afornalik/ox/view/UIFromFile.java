package com.afornalik.ox.view;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

/**
 * Class read input from file and save match result into file result.txt.
 */
public class UIFromFile extends UI {

    private final List<String> allLines;
    private final int counter;
    private BufferedWriter writer;
    private Iterator<String> stringIterator;

    /**
     * Default constructor scanner need to be specified.
     *
     * @param scanner object hold input from a user.
     * @param file    file holding arguments
     */
    public UIFromFile(Scanner scanner, File file,int counter) {
        super(scanner);
        allLines = readFile(file);
        this.counter = counter;
        splitLine();
        try {
            writer = new BufferedWriter(new FileWriter("result.txt",true));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public List<String> getAllLines() {
        return allLines;
    }

    private List<String> readFile(File file) {
        try {
            if (writer == null){
                return Files.readAllLines(file.toPath());
            }
        } catch (IOException e) {
            print("File '" + file.getName() + "' does not exist\n\n");
        }
        return Collections.emptyList();
    }

    private void splitLine() {
        if (counter > 0) {
            allLines.subList(0, counter).clear();
        }
        List<String> lineArguments = Arrays.asList(allLines.get(0).split(" "));
        stringIterator = lineArguments.iterator();
    }

    /**
     * @return return PrintWriter generally to close this writer.
     */
    public BufferedWriter getWriter() {
        return writer;
    }

    /**
     * Method print string into file.
     * Also call super.print(string) method, which print output on console.
     *
     * @param string String to be printed out by PrintWriter into file
     */
    @Override
    public void print(String string) {
        super.print(string);
        try {
            writer.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * read next text from array, convert into int value and put it instead of user input.
     *
     * @return int number from array red from file
     */
    @Override
    public int readNumber() {
        String number = stringIterator.next();
        print(number + "\n");
        //writer.println(number);
        return Integer.parseInt(number);
    }

    /**
     * read next text from array and put it instead of user input
     *
     * @return String number from array red from file
     */
    @Override
    public String read() {
        String text = stringIterator.next();
        print(text + "\n");
        // writer.println(text);
        return text;
    }
}
