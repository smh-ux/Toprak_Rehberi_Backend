package com.example.Internship.Service;

import com.example.Internship.Entity.Town;
import com.example.Internship.Repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TownService {

    @Autowired
    private TownRepository townRepository;

    public List<Town> getTownsByCity(Long cityId) {
        return townRepository.findByCityId(cityId);
    }
}