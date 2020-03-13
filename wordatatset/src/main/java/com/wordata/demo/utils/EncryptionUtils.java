package com.wordata.demo.utils;

import java.security.MessageDigest;

public class EncryptionUtils {
    // 암호화 클래스 sha 알고리즘으로 암호화 한다.

    public static String encrypt(String s, String messageDigest) {
        try {
            MessageDigest md = MessageDigest.getInstance(messageDigest);
            byte[] passByte = s.getBytes();
            md.reset();
            byte[] digested = md.digest(passByte);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();

        } catch (Exception e) {
            return s;
        }
    }

    public static String encryptSHA256(String s) {
        return encrypt(s, "SHA-256");
    }
}
