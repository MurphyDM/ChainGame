package com.company.logic.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HMACGenerator {
    private String algoritm = "HmacSHA256";
    private String key = "";

    public HMACGenerator() {
        SRandomGenerator sRandom = new SRandomGenerator();
        this.key = sRandom.generateRandomHexString(32);
    }

    public String createHMAC(String data) {
        String hmac = "";

        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.key.getBytes("UTF-8"), this.algoritm);
            Mac mac = Mac.getInstance(this.algoritm);
            mac.init(secretKeySpec);
            byte[] bytes = mac.doFinal(data.getBytes("ASCII"));
            StringBuffer hash = new StringBuffer();
            for (int i = 0; i < bytes.length; ++i) {
                String hex = Integer.toHexString(255 & bytes[i]);
                if (hex.length() == 1) {
                    hash.append('0');
                }

                hash.append(hex);
            }
            hmac = hash.toString();
        } catch (InvalidKeyException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return hmac;
    }

    public String getKey() {
        return this.key;
    }
}
