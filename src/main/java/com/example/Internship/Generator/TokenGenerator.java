package com.example.Internship.Generator;

public class TokenGenerator {
    // Token oluşturma fonksiyonu
    public static String generateToken(String userId) {
        long userIdNumber = Long.parseLong(userId); // Kullanıcı ID'sini uzun bir sayıya dönüştür
        long tokenValue = (userIdNumber * 127 + 22) * 1234567; // Verilen formülü kullan

        return Long.toString(tokenValue); // Token'ı String olarak döndür
    }
}
