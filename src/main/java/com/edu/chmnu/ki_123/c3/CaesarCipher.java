package com.edu.chmnu.ki_123.c3;

public class CaesarCipher {
    private final int shift;

    public CaesarCipher(int shift) {
        this.shift = (shift % 26 + 26) % 26;
    }

    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char encryptedChar = (char) ((c - base + shift) % 26 + base);
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    public String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char decryptedChar = (char) ((c - base - shift + 26) % 26 + base);
                decrypted.append(decryptedChar);
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }
}