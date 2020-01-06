package com.afornalik.ox.view;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class UIFromFile extends UI {

    private final List<String> allLines;
    private List<String> lineArguments;
    private Iterator<String> stringIterator;
    /**
     * Default constructor scanner need to be specified.
     *
     * @param scanner object hold input from a user.
     * @param file file holding arguments
     */
    public UIFromFile(Scanner scanner, File file) {
        super(scanner);
        allLines = readFile(file);
        splitLine();
    }

    private List<String> readFile(File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private void splitLine(){
       lineArguments = Arrays.asList(allLines.get(0).split(" "));
       stringIterator = lineArguments.iterator();
    }

    @Override
    public void print(String string) {
        super.print(string);
    }

    @Override
    public int readNumber() {
        String number = stringIterator.next();
        print(number);
        return  Integer.valueOf(number);
    }

    @Override
    public String read() {
        String text = stringIterator.next();
        print(text);
        return text;
    }
}
