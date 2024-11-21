package com.edu.chmnu.ki_123.c3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CaesarCipherTest {

    // Тест базового шифрування та дешифрування
    @Test
    void testEncryptionDecryption() {
        int shift = 3;
        CaesarCipher cipher = new CaesarCipher(shift);

        String originalText = "Hello, World!";
        String encryptedText = cipher.encrypt(originalText);
        String decryptedText = cipher.decrypt(encryptedText);

        assertNotEquals(originalText, encryptedText, "Encrypted text should differ from original text");
        assertEquals(originalText, decryptedText, "Decrypted text should match the original text");
    }

    // Тест шифрування тексту, що містить лише пробіли та спец. символи
    @Test
    void testSpecialCharactersAndSpaces() {
        int shift = 5;
        CaesarCipher cipher = new CaesarCipher(shift);

        String originalText = "   !!! ??? @@@ ###";
        String encryptedText = cipher.encrypt(originalText);
        String decryptedText = cipher.decrypt(encryptedText);

        assertEquals(originalText, decryptedText, "Special characters and spaces should remain unchanged");
    }

    // Тест шифрування тексту з негативним значенням зсуву
    @Test
    void testNegativeShift() {
        int shift = -3;
        CaesarCipher cipher = new CaesarCipher(shift);

        String originalText = "Negative Test";
        String encryptedText = cipher.encrypt(originalText);
        String decryptedText = cipher.decrypt(encryptedText);

        assertEquals(originalText, decryptedText, "Decrypted text should match the original text with negative shift");
    }
}