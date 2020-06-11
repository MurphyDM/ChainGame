package com.company.logic;

import com.company.logic.util.MovesValidator;

public class GameLogic {
    private Computer computer = new Computer();
    private User user = new User();

    public void startGame(String[] moves) {
        this.checkMoves(moves);
        MoveLogic moveLogic = new MoveLogic(moves);
        Move opponentMove = moveLogic.initializeMove(this.computer.doMove(moves));
        Move userMove = moveLogic.initializeMove(this.user.doMove(moves));
        this.announceResult(userMove, opponentMove);
        this.computer.showSecureKey();
    }

    private void checkMoves(String[] moves) {
        MovesValidator movesValidator = new MovesValidator();
        if(!movesValidator.isValid(moves)) System.exit(1);
    }

    private void announceResult(Move userMove, Move opponentMove) {
        System.out.printf("Your move: %s \n", userMove.getName());
        System.out.printf("Opponent move: %s \n", opponentMove.getName());
        if (userMove.compareTo(opponentMove) == 1) {
            System.out.printf("You win!\n");
        } else if (opponentMove.compareTo(userMove) == 1) {
            System.out.printf("The winner is computer!\n");
        } else {
            System.out.printf("The is a draw.\n");
        }

    }
}
