package com.afornalik.ox.controller;

import com.afornalik.ox.view.UISimple;


class HeadController {

    private final UISimple uiSimple;


    HeadController( UISimple uiSimple) {
        this.uiSimple = uiSimple;
    }

    void greetUser() {
        //actual version --> should be in view package
        uiSimple.print("Welcome in game OX\n\n");
    }
}
