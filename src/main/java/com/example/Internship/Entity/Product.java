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
    private int plantedArea;

    @ManyToOne
    @JoinColumn(name = "land_id")
    private Land land;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlantedArea() {
        return plantedArea;
    }

    public void setPlantedArea(int plantedArea) {
        this.plantedArea = plantedArea;
    }

}