package com.example.Internship.Service;

import com.example.Internship.Entity.Token;
import com.example.Internship.Entity.User;
import com.example.Internship.Generator.TokenGenerator;
import com.example.Internship.Repository.TokenRepository;
import com.example.Internship.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;

    public Token generateToken(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        String tokenValue = TokenGenerator.generateToken(userId.toString());

        Token token = new Token();
        token.setToken(tokenValue);
        token.setUser(user);
        token.setCreatedAt(LocalDateTime.now());
        token.setExpiresAt(LocalDateTime.now().plusHours(1)); // Token geçerlilik süresi 1 saat

//        // Kullanıcının eski token'ını kaldırmak için
//        if (user.getToken() != null) {
//            tokenRepository.delete(user.getToken());
//        }

        if (token.getExpiresAt().isAfter(LocalDateTime.now())) {
            tokenRepository.delete(token);
        }


        return tokenRepository.save(token);
    }

    public boolean validateToken(String tokenValue) {
        Token token = tokenRepository.findByToken(tokenValue);
        return token != null && token.getExpiresAt().isAfter(LocalDateTime.now());
    }
}