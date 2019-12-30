package com.afornalik.ox.view;

import com.afornalik.ox.model.board.Board;

public interface UIOperations {

    void print(String draw);

    void drawBoard();

    void drawBoard(Board board);

    int readNumber();

    String read();

}
