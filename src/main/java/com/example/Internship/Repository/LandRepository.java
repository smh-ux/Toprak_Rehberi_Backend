package com.example.Internship.Repository;

import com.example.Internship.Entity.Land;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LandRepository extends JpaRepository<Land, Long> {
    Optional<Land> findByLandNameAndCityAndTownAndNeighborhoodAndArea(String landName, String city, String town, String neighborhood, int area);
}
