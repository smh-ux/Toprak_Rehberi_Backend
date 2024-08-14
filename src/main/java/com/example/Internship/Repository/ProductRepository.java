package com.example.Internship.Repository;

import com.example.Internship.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByNameAndPlantedArea(String name, int plantedArea);
}
