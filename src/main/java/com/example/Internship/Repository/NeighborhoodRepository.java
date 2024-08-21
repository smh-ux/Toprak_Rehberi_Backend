package com.example.Internship.Repository;

import com.example.Internship.Entity.Neighborhood;
import com.example.Internship.Entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Long> {
    List<Neighborhood> findByTownId(Long townId);
}