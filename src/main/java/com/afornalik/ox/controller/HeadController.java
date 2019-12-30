package com.afornalik.ox.controller;

import com.afornalik.ox.view.UIOperations;


class HeadController {

    private UIOperations uiOperations;


    HeadController( UIOperations uiOperations) {
        this.uiOperations = uiOperations;
    }

    void greetUser() {
        //actual version --> should be in view package
        uiOperations.print("Welcome in game OX\n\n");
    }
}
