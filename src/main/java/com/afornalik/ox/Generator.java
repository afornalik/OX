package com.afornalik.ox;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class Generator {
    public static void main(String[] args) {


       /* StringBuilder stringBuilder= new StringBuilder();
        int condition = 3;
        int borderSize = 3;
        int index =0;
        int counter = 1;
        int borderMax = borderSize * borderSize;
        for(int y = 0; y <=(borderSize -condition); y++) {
            for (int j = 1; j <= borderSize; j++) {

                for (int i = 0; i <= borderMax; i++) {
                    if (i % 2 == 0) {
                        stringBuilder.append(" " + (y+index+(j*borderSize) + counter));
                        counter++;
                    } else {
                        if (y+index + counter >= ((borderMax - condition) + counter - 1)) {
                            stringBuilder.append(" " + (counter));
                        } else {
                            stringBuilder.append(" " + ((borderMax - condition) + counter - 1));
                        }
                    }
                }
                counter = 1;
                index = index + borderSize;
                stringBuilder.append("\n");
            }
            index =0;
            counter = 1;
        }
        System.out.println(stringBuilder.toString());

*/


        horizontal();

    }

    private static void horizontal() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("horizontal.txt", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int board = 3; board <=30; board++) {
            for (int condition = 3; condition <= board; condition++) {
                int borderSize = board;
                int index = 0;
                int counter = 1;
                int borderMax = borderSize * borderSize;
                for (int y = 0; y <= (borderSize - condition); y++) {
                    for (int j = 1; j <= borderSize; j++) {
                        stringBuilder.append("gracz1 x 1 gracz2 "+borderSize+" "+condition);
                        for (int i = 0; i <= borderMax; i++) {
                            if (i % 2 == 0) {
                                stringBuilder.append(" " + (y + index + counter));
                                counter++;
                            } else {
                                if (y + index + counter >= ((borderMax - condition) + counter - 3)) {
                                    stringBuilder.append(" " + (counter));
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
