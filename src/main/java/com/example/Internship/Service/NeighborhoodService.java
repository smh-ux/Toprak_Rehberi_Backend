package com.example.Internship.Service;

import com.example.Internship.Entity.Neighborhood;
import com.example.Internship.Entity.Town;
import com.example.Internship.Repository.NeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NeighborhoodService {

    @Autowired
    NeighborhoodRepository neighborhoodRepository;

    public List<Neighborhood> getNeighborhoodsByTown(Long townID) {
        return neighborhoodRepository.findByTownId(townID);
    }

}