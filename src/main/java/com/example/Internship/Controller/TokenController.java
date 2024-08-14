package com.example.Internship.Controller;

import com.example.Internship.Entity.Token;
import com.example.Internship.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tokens")
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateToken(@RequestParam Long userId) {
        Token token = tokenService.generateToken(userId);
        return ResponseEntity.ok(token.getToken());
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validateToken(@RequestParam String token) {
        boolean isValid = tokenService.validateToken(token);
        return ResponseEntity.ok(isValid);
    }
}
