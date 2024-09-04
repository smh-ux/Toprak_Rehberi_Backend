package com.example.Internship.Generator;

public class TokenGenerator {
    // Token oluşturma fonksiyonu
    public static String generateToken(String userId) {
        long userIdNumber = Long.parseLong(userId);
        long tokenValue = (userIdNumber * 127 + 22) * 1234567;

        return Long.toString(tokenValue);
    }
}
