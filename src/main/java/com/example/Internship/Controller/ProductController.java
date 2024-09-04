package com.example.Internship.Controller;

import com.example.Internship.DTO.LandDTO;
import com.example.Internship.DTO.ProductDTO;
import com.example.Internship.Entity.*;
import com.example.Internship.Repository.LandRepository;
import com.example.Internship.Repository.PeriodRepository;
import com.example.Internship.Repository.ProductRepository;
import com.example.Internship.Repository.SuccessRateRepository;
import com.example.Internship.Request.EvaluationRequest;
import com.example.Internship.Service.ProductService;
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

    @Autowired
    private PeriodRepository periodRepository;

    @Autowired
    private SuccessRateRepository successRateRepository;

    @Autowired
    private ProductService productService;

    @PostMapping("/adding")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO) {
        Land land = landRepository.findById(productDTO.getLandId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Arazi bulunamadı"));
        Period period = periodRepository.findById(productDTO.getPeriodId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Period bulunamadı"));
        SuccessRate successRate = successRateRepository.findById(productDTO.getSuccessRateId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Başarı oranı bulunamadı"));
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPlantedArea(productDTO.getPlantedArea());
        product.setPeriod(period);
        product.setSuccessRate(successRate);
        product.setLand(land);

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

    @GetMapping("/period/{periodId}")
    public ResponseEntity<List<Product>> getPeriodByProductId(@PathVariable Long periodId) {
        List<Product> products = productRepository.findByPeriodId(periodId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/successRate/{successrateId}")
    public ResponseEntity<List<Product>> getSuccessRateByProductId(@PathVariable Long successrateId) {
        List<Product> products = productRepository.findBySuccessRateId(successrateId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/evaluate")
    public ResponseEntity<String> evaluateProducts(@RequestBody EvaluationRequest evaluationRequest) {
        try {
            productService.saveEvaluations(evaluationRequest);
            return ResponseEntity.ok("Evaluations saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving evaluations.");
        }
    }

    //
//    @GetMapping("/product/{productId}")
//    public ResponseEntity<List<SuccessRate>> getSuccessRateByProductId(@PathVariable Long productId) {
//        List<SuccessRate> rates = successRateRepository.findByProductId(productId);
//        return new ResponseEntity<>(rates, HttpStatus.OK);
//    }
//
//    @PostMapping("/update")
//    public ResponseEntity<String> updateSuccessRates() {
//        //successRateRepository.calculateAndUpdateSuccessRate();
//        return ResponseEntity.ok("Success Rate updated successfully.");
//    }

}