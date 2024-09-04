package com.example.Internship.Controller;

import com.example.Internship.Entity.Product;
import com.example.Internship.Entity.ProductInfoFull;
import com.example.Internship.Repository.ProductInfoFullRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productinfofull")
public class ProductInfoFullController {

    @Autowired
    private ProductInfoFullRepository productInfoFullRepository;

    @GetMapping("/fetch")
    public ResponseEntity<List<ProductInfoFull>> getAllProducts() {
        List<ProductInfoFull> productinfofulls = productInfoFullRepository.findAll();
        return new ResponseEntity<>(productinfofulls, HttpStatus.OK);
    }

}
