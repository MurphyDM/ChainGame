package com.company.logic.util;

import java.security.SecureRandom;

public class SRandomGenerator {
    public String generateRandomHexString(int size){
        String result = javax.xml.bind.DatatypeConverter.printHexBinary(generateRandomBytes(size));
        return result;
    }

    public int generateRandomIntValue( int floor, int scale) {
        SecureRandom random = new SecureRandom();
        int result = 0;
        while(result < floor) result = random.nextInt(scale);
        return result;
    }

    private byte[] generateRandomBytes(int size){
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        return bytes;
    }
}
