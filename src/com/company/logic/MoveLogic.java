package com.company.logic;

import com.company.exception.WrongArgumentException;

import java.util.HashMap;
import java.util.Map;

public class MoveLogic {
    private Map<Integer, Move> moves = new HashMap();
    int numOfLoosers;

    public MoveLogic(String[] args) {
        numOfLoosers = args.length / 2;
        moves = new HashMap<>();
        defineCommandLoosers(args);
    }

    private void defineCommandLoosers(String[] args) {
        for (int commandNum = 0; commandNum < args.length; commandNum++) {
            String[] loosers = new String[numOfLoosers];
            int looserPos = commandNum + 1;
            for (int i = 0; i < numOfLoosers; i++) {
                if (looserPos == args.length) looserPos = 0;
                loosers[i] = args[looserPos];
                looserPos++;
            }
            int key = commandNum;
            this.moves.put(key + 1, new Move(args[commandNum], loosers));
        }
    }

    public Map<Integer, Move> getMoves() {
        return this.moves;
    }

    public Move initializeMove(int number) {
        Move move = null;

        try {
            move = new Move((Move)this.moves.get(number));
            if (move == null) {
                throw new WrongArgumentException();
            }
        } catch (WrongArgumentException e) {
            e.printStackTrace();
        }

        return move;
    }
}
