package com.company.logic;

import com.company.logic.util.HMACGenerator;
import com.company.logic.util.SRandomGenerator;

public class Computer {
    HMACGenerator hmac = new HMACGenerator();

    public int doMove(String[] moves) {
        SRandomGenerator sRand = new SRandomGenerator();
        int moveNumber = sRand.generateRandomIntValue(1, moves.length);
        MoveLogic moveLogic = new MoveLogic(moves);
        Move move = moveLogic.initializeMove(moveNumber);
        String moveName = move.getName();
        System.out.printf("HMAC: %s \n", this.hmac.createHMAC(moveName));
        return moveNumber;
    }

    public void showSecureKey() {
        System.out.printf("Secure key: %s\n", this.hmac.getKey());
    }
}
