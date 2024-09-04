package com.example.Internship.Repository;

import com.example.Internship.Entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ProductInfoRepository extends JpaRepository<ProductInfo, Long> {
}
