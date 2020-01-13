package com.afornalik.ox;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

class Generator {

    public static void main(String[] args) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("draw.txt", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int board = 3; board <= 40; board++) {
            int borderSize = board;
            int index = 0;
            int counter = 1;
            int borderMax = borderSize * borderSize;
            stringBuilder.append("gracz1 x 1 gracz2 ").append(borderSize).append(" ").append(3);
            for (int i = 1; i <= borderMax; i++) {
                if (board == 3 || board == 7 || board == 11 || board == 15 || board == 19 || board == 23 || board == 27) {
                    if (i > borderSize && i <= 3 * borderSize ||
                            i > 5 * borderSize && i <= 7 * borderSize ||
                            i > 9 * borderSize && i <= 11 * borderSize ||
                            i > 13 * borderSize && i <= 15 * borderSize ||
                            i > 17 * borderSize && i <= 19 * borderSize ||
                            i > 21 * borderSize && i <= 23 * borderSize ||
                            i > 25 * borderSize && i <= 27 * borderSize ||
                            i > 29 * borderSize && i <= 31 * borderSize) {
                        if (i % 2 != 0) {
                            stringBuilder.append(" " + (i - 1));
                        } else {
                            if (i == borderMax) {
                                stringBuilder.append(" " + (i));
                            } else {
                                stringBuilder.append(" " + (i + 1));
                            }
                        }
                    } else {
                        stringBuilder.append(" " + i);
                    }
                } else {
                    if (i > 2 * borderSize && i <= 4 * borderSize ||
                            i > 6 * borderSize && i <= 8 * borderSize ||
                            i > 10 * borderSize && i <= 12 * borderSize ||
                            i > 14 * borderSize && i <= 16 * borderSize ||
                            i > 18 * borderSize && i <= 20 * borderSize ||
                            i > 22 * borderSize && i <= 24 * borderSize ||
                            i > 26 * borderSize && i <= 28 * borderSize) {
                        if (i % 2 == 0) {
                            stringBuilder.append(" " + (i - 1));
                        } else {
                            if (i == borderMax) {
                                stringBuilder.append(" " + (i));
                            } else {
                                stringBuilder.append(" " + (i + 1));
                            }
                        }
                    } else {
                        stringBuilder.append(" " + i);
                    }
                }
                counter = 0;
                printWriter.write(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }


    static void diagonalRight() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("diagonalright.txt", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int board = 3; board <= 30; board++) {
            for (int condition = 3; condition <= board; condition++) {
                int borderSize = board;
                int index = 0;
                int counter = 0;
                int borderMax = borderSize * borderSize;
                for (int y = 0; y <= (borderSize - condition); y++) {
                    for (int j = 0; j <= borderSize - condition; j++) {
                        stringBuilder.append("gracz1 x 1 gracz2 " + borderSize + " " + condition);
                        int diagonal = 0;
                        for (int i = 0; i <= borderMax; i++) {
                            if (i % 2 == 0) {
                                stringBuilder.append(" " + (((y * borderSize) + (borderSize - index) + (counter * borderSize)) - diagonal));
                                counter++;
                                diagonal++;
                            } else {
                                if (diagonal != borderSize) {
                                    stringBuilder.append(" " + diagonal);
                                } else {
                                    stringBuilder.append(" " + (diagonal + 1));
                                }
                            }
                        }
                        counter = 0;
                        index = index + 1;
                        stringBuilder.append("\n");
                        printWriter.write(stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                    }
                    index = 0;
                    counter = 0;
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }

    static void diagonalLeft() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("diagonalleft.txt", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int board = 3; board <= 30; board++) {
            for (int condition = 3; condition <= board; condition++) {
                int borderSize = board;
                int index = 1;
                int counter = 0;
                int borderMax = borderSize * borderSize;
                for (int y = 0; y <= (borderSize - condition); y++) {
                    for (int j = 0; j <= borderSize - condition; j++) {
                        stringBuilder.append("gracz1 x 1 gracz2 " + borderSize + " " + condition);
                        int diagonal = 0;
                        for (int i = 0; i <= borderMax; i++) {
                            if (i % 2 == 0) {
                                stringBuilder.append(" " + (((y * borderSize) + index + (counter * borderSize)) + diagonal));
                                counter++;
                                diagonal++;
                            } else {
                                if (index == borderSize) {
                                    stringBuilder.append(" " + (1 + ((counter - 1) * borderSize)));
                                } else {
                                    stringBuilder.append(" " + ((borderSize * counter)));
                                }
                            }
                        }
                        counter = 0;
                        index = index + 1;
                        stringBuilder.append("\n");
                        printWriter.write(stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                    }
                    index = 1;
                    counter = 0;
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }

    static void vertical() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("vertical.txt", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int board = 3; board <= 30; board++) {
            for (int condition = 3; condition <= board; condition++) {
                int borderSize = board;
                int index = 1;
                int counter = 0;
                int borderMax = borderSize * borderSize;
                for (int y = 0; y <= (borderSize - condition); y++) {
                    for (int j = 1; j <= borderSize; j++) {
                        stringBuilder.append("gracz1 x 1 gracz2 " + borderSize + " " + condition);
                        for (int i = 0; i <= borderMax; i++) {
                            if (i % 2 == 0) {
                                stringBuilder.append(" " + ((y * borderSize) + index + (counter * borderSize)));
                                counter++;
                            } else {
                                if (index == borderSize) {
                                    stringBuilder.append(" " + (1 + ((counter - 1) * borderSize)));
                                } else {
                                    stringBuilder.append(" " + ((borderSize * counter)));
                                }
                            }
                        }
                        counter = 0;
                        index = index + 1;
                        stringBuilder.append("\n");
                        printWriter.write(stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                    }
                    index = 1;
                    counter = 0;
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }


    static void horizontal() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("horizontal.txt", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int board = 3; board <= 30; board++) {
            for (int condition = 3; condition <= board; condition++) {
                int borderSize = board;
                int index = 0;
                int counter = 1;
                int borderMax = borderSize * borderSize;
                for (int y = 0; y <= (borderSize - condition); y++) {
                    for (int j = 1; j <= borderSize; j++) {
                        stringBuilder.append("gracz1 x 1 gracz2 " + borderSize + " " + condition);
                        for (int i = 0; i <= borderMax; i++) {
                            if (i % 2 == 0) {
                                stringBuilder.append(" " + (y + index + counter));
                                counter++;
                            } else {
                                if (y + index + counter > borderSize) {
                                    stringBuilder.append(" " + (counter - 1));
                                } else {
                                    stringBuilder.append(" " + ((borderMax - condition) + counter - 1));
                                }
                            }
                        }
                        counter = 1;
                        index = index + borderSize;
                        stringBuilder.append("\n");
                        printWriter.write(stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                    }
                    index = 0;
                    counter = 1;
                }
            }
        }
        System.out.println(stringBuilder.toString());
        printWriter.close();
    }



  /*  int index =0;
    int counter = 1;
    int condition = 3;
    int borderMax = 9;
        for (int j = 1; j <= 3; j++) {
        for (int i = 0; i <= borderMax; i++) {
            if (i % 2 == 0) {
                stringBuilder.append(" "+(index + counter));
                counter++;
            } else {
                if(index+counter>= ((borderMax-condition)+counter-1)){
                    stringBuilder.append(" "+(counter));
                }else {
                    stringBuilder.append(" " + ((borderMax - condition) + counter - 1));
                }
            }
        }
        counter = 1;
        index= index+condition;
        stringBuilder.append("\n");
    }
        System.out.println(stringBuilder.toString());*/

/*
    public List<Integer> generateHor(int borderSize) {
        for()
    }
*/


}
