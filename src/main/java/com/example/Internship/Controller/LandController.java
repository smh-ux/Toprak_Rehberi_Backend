package com.example.Internship.Controller;

import java.util.List;

import com.example.Internship.DTO.LandDTO;
import com.example.Internship.Entity.Land;
import com.example.Internship.Entity.Neighborhood;
import com.example.Internship.Entity.User;
import com.example.Internship.Repository.LandRepository;
import com.example.Internship.Repository.NeighborhoodRepository;
import com.example.Internship.Repository.UserRepository;
import com.example.Internship.Request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/lands")
public class LandController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LandRepository landRepository;

    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    @PostMapping("/adding")
    public ResponseEntity<Land> addLand(@RequestBody LandDTO landDTO) {
        User user = userRepository.findById(landDTO.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Kullanıcı bulunamadı"));
        Neighborhood neighborhood = neighborhoodRepository.findById(landDTO.getNeighborhoodId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mahalle bulunamadı"));
        Land land = new Land();
        land.setLandName(landDTO.getLandName());
        land.setCity(landDTO.getCity());
        land.setTown(landDTO.getTown());
        land.setNeighborhood(landDTO.getNeighborhood());
        land.setArea(landDTO.getArea());
        land.setNeighborhood_id(neighborhood);
        land.setUser(user);
        Land addedLand = landRepository.save(land);

        return new ResponseEntity<>(addedLand, HttpStatus.CREATED);
    }

    @GetMapping("/fetching")
    public ResponseEntity<List<Land>> getAllLands() {
        List<Land> lands = landRepository.findAll();

        return new ResponseEntity<>(lands, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Land>> getLandsByUserId(@PathVariable Long userId) {
        List<Land> lands = landRepository.findByUserId(userId);

        return new ResponseEntity<>(lands, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteLand(@RequestBody LandDTO landDTO) {
        Land land = landRepository.findById(landDTO.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Arazi bulunamadı"));
        landRepository.delete(land);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}