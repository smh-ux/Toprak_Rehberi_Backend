package com.example.Internship.Repository;

import com.example.Internship.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Optional<User> findByUsername(String username);
    Optional<User> findByUsername(String username);
}

