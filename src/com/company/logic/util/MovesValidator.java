package com.company.logic.util;

import com.company.exception.IllegalInputException;

import java.util.HashMap;
import java.util.Map;

public class MovesValidator {

    public boolean isValid(String[] moves) {
        try {
            checkAmount(moves);
            checkRepeats(moves);
        }catch (IllegalInputException e) {
            e.printStackTrace();
            return false;
        }
     return true;
    }

    public void checkAmount(String[] moves) throws IllegalInputException{
        if(moves.length %2==0 || moves.length <= 1) throw new IllegalInputException("Incorrect amount of moves");
    }

    public void  checkRepeats(String[] moves) throws IllegalInputException{
        Map<String, Integer> validMoves = new HashMap();

        for (String move : moves) {
            Integer frequency = validMoves.get(move);
            if ( frequency != null) throw new IllegalInputException("Repetitions prohibited.");
            validMoves.put(move, 1);
        }
    }

}
