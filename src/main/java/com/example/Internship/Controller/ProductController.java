package com.example.Internship.Controller;

import com.example.Internship.DTO.LandDTO;
import com.example.Internship.DTO.ProductDTO;
import com.example.Internship.Entity.Land;
import com.example.Internship.Entity.Product;
import com.example.Internship.Entity.User;
import com.example.Internship.Repository.LandRepository;
import com.example.Internship.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private LandRepository landRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/adding")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO) {
        Land land = landRepository.findById(productDTO.getLandId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Arazi bulunamadı"));
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPlantedArea(productDTO.getPlantedArea());

        product.setLand(land); // Araziyi ayarla

        Product addedProduct = productRepository.save(product);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/fetching")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/land/{landId}")
    public ResponseEntity<List<Product>> getProductsByLandId(@PathVariable Long landId) {
        List<Product> products = productRepository.findByLandId(landId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}