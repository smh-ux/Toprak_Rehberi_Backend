package com.example.Internship.Repository;

import com.example.Internship.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByNameAndPlantedArea(String name, int plantedArea);

    List<Product> findByLandId(Long landId);
    List<Product> findByPeriodId(Long periodId);
    List<Product> findBySuccessRateId(Long successrateId);

//    @Modifying
//    @Query("UPDATE Product p SET p.averageEvaluation = :average WHERE p.name = :productName")
//    void updateProductEvaluation(@Param("productName") String productName, @Param("average") double average);

}
