package com.company.logic;

import com.company.logic.util.CommandMenu;
import com.company.exception.IllegalInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User implements Movable {
    public static final int EXTENDED_MODE = 5;
    public static final int CLASSIC_MODE = 3;
    public static final int EXIT_GAME_COMMAND = 0;

    public int doMove(String[] moves){
        int move;
        do {
            showAvailableMoves(moves);
            move = enterMove(moves.length);
        } while(move == -1);
        if (move == EXIT_GAME_COMMAND) System.exit(0);
        return move;
    }

    private int enterMove(int sail){
        int move = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter move: ");
        try {
            move = in.nextInt();
            if(move < EXIT_GAME_COMMAND||move > sail) throw new IllegalInputException();
        } catch (InputMismatchException |IllegalInputException e){
            System.err.println("Incorrect. Try again.");
            return -1;
        }
        return move;
    }

    private void showAvailableMoves(String[] moves) {
        CommandMenu availableMoves = new CommandMenu();
        availableMoves.showCommandMenu(moves);
    }
}
