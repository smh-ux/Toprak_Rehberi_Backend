package com.example.Internship.Repository;

import com.example.Internship.Entity.Product;
import com.example.Internship.Entity.SuccessRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SuccessRateRepository extends JpaRepository<SuccessRate, Long> {
    @Modifying
    @Query("UPDATE SuccessRate sr SET sr.averageRate = :average WHERE sr.name = :name")
    void updateSuccessRate(@Param("name") String name, @Param("average") double average);
}