package com.example.Internship.Repository;

import com.example.Internship.Entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TownRepository extends JpaRepository<Town, Long> {
    List<Town> findByCityId(Long cityId);
}