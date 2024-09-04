package com.example.Internship.Repository;

import com.example.Internship.Entity.Token;
import com.example.Internship.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}
