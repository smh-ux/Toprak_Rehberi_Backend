package com.example.Internship.Controller;

import java.util.List;

import com.example.Internship.DTO.LandDTO;
import com.example.Internship.DTO.ProductDTO;
import com.example.Internship.Entity.Land;
import com.example.Internship.Entity.Neighborhood;
import com.example.Internship.Entity.Product;
import com.example.Internship.Entity.User;
import com.example.Internship.Repository.LandRepository;
import com.example.Internship.Repository.NeighborhoodRepository;
import com.example.Internship.Repository.ProductRepository;
import com.example.Internship.Repository.UserRepository;
import com.example.Internship.Request.LoginRequest;
import com.example.Internship.Service.LandService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/lands")
public class LandController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LandRepository landRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    @Autowired
    private LandService landService;

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

//    @PostMapping("/land/delete")
//    public ResponseEntity<LandDTO> deleteLand(@RequestBody LandDTO landDTO) {
//        Land land = landRepository.findById(landDTO.getUserId())
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Arazi bulunamadı"));
//        landRepository.delete(land);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PostMapping("/product/delete")
//    public ResponseEntity<ProductDTO> deleteProduct(@RequestBody LandDTO landDTO) {
//        Land land = landRepository.findById(landDTO.getUserId())
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Arazi bulunamadı"));
//        landRepository.delete(land);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    @DeleteMapping("/delete/{landId}")
    @Transactional
    public ResponseEntity<String> deleteLand(@PathVariable Long landId) {
        Land land = landRepository.findById(landId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Land not found with id: " + landId));

        productRepository.deleteByLandId(landId);

        landRepository.delete(land);

        return ResponseEntity.ok("Arazi ve ürünler başarıyla silindi.");
    }
}