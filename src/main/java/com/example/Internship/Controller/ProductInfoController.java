package com.example.Internship.Controller;

import com.example.Internship.Entity.Product;
import com.example.Internship.Entity.ProductInfo;
import com.example.Internship.Repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productinfo")
public class ProductInfoController {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @GetMapping("/fetch")
    public ResponseEntity<List<ProductInfo>> getAllProducts() {
        List<ProductInfo> productinfos = productInfoRepository.findAll();
        return new ResponseEntity<>(productinfos, HttpStatus.OK);
    }
}
