package com.example.Internship.Repository;

import com.example.Internship.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// This is for manage the CRUD process.

public interface UserRepository extends JpaRepository<User, Long> {
    // Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);
}

