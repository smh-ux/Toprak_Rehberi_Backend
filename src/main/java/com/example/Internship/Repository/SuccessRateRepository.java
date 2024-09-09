package com.example.Internship.Repository;

import com.example.Internship.Entity.Neighborhood;
import com.example.Internship.Entity.Product;
import com.example.Internship.Entity.SuccessRate;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SuccessRateRepository extends JpaRepository<SuccessRate, Long> {
    @Query("SELECT sr FROM SuccessRate sr WHERE sr.name = :name AND sr.neighborhood.id = :neighborhoodId")
    SuccessRate findByNameAndNeighborhoodId(@Param("name") String name, @Param("neighborhoodId") Long neighborhoodId);

    List<SuccessRate> findByNeighborhoodId(Long neighborhoodId);

    @Transactional
    @Modifying
    @Query("UPDATE SuccessRate sr SET sr.averageRate = :average, sr.count = :count WHERE sr.name = :name AND sr.neighborhood.id = :neighborhoodId")
    void updateSuccessRate(@Param("name") String name, @Param("average") double average, @Param("count") int count, @Param("neighborhoodId") Long neighborhoodId);
}