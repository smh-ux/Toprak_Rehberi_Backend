package com.example.Internship.Entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String harvestPeriod;

    @Column(nullable = false)
    private String plantedPeriod;

    @Column(nullable = false)
    private int plantedArea;

    @ManyToOne
    @JoinColumn(name = "land_id")
    private Land land;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHarvestPeriod() {
        return harvestPeriod;
    }

    public void setHarvestPeriod(String harvestPeriod) {
        this.harvestPeriod = harvestPeriod;
    }

    public String getPlantedPeriod() {
        return plantedPeriod;
    }

    public void setPlantedPeriod(String plantedPeriod) {
        this.plantedPeriod = plantedPeriod;
    }

    public int getPlantedArea() {
        return plantedArea;
    }

    public void setPlantedArea(int plantedArea) {
        this.plantedArea = plantedArea;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }
}