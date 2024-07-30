package com.example.Internship.Controller;

import com.example.Internship.Entity.Land;
import com.example.Internship.Entity.User;
import com.example.Internship.Repository.LandRepository;
import com.example.Internship.Repository.UserRepository;
import com.example.Internship.Request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/lands")
public class LandController {
    @Autowired
    private LandRepository landRepository;

    @PostMapping("/adding")
    public ResponseEntity<Land> addLand(@RequestBody Land land) {
        Land addedLand = landRepository.save(land);
        return new ResponseEntity<>(addedLand, HttpStatus.CREATED);
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
//        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
//
//        if (optionalUser.isPresent()) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(401).body("Invalid username or password");
//        }
//    }
}
