package com.example.Internship.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int plantedArea;

    @ManyToOne
    @JoinColumn(name = "land_id")
    private Land land;

    @OneToOne
    @JoinColumn(name = "period_id")
    private Period period;

    @OneToOne
    @JoinColumn(name = "successRate_id")
    private SuccessRate successRate;

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

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public SuccessRate getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(SuccessRate successRate) {
        this.successRate = successRate;
    }
}