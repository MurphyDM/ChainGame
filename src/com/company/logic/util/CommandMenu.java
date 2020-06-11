package com.company.logic.util;

public class CommandMenu {
    public void showCommandMenu(String[] moves) {
        System.out.println("Available moves: ");

        for(int i = 0; i < moves.length; ++i) {
            System.out.printf("%d - %s \n", i + 1, moves[i]);
        }

        System.out.println("0 - exit");
    }
}
