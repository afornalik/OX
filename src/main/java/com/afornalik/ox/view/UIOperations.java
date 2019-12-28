package com.afornalik.ox.view;

import com.afornalik.ox.model.board.Board;

public interface UIOperations {

    void print(String draw);

    int readNumber();

    String read();

    void drawBoard();

    void drawBoard(Board board);

}
