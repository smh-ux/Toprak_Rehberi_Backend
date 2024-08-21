package com.example.Internship.Entity;

import jakarta.persistence.*;

@Entity
public class SuccessRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String harvest_period;

    @Column(nullable = false)
    private int rate;

    @Column(nullable = false)
    private String plant_period;

    public String getPlant_period() {
        return plant_period;
    }

    public void setPlant_period(String plant_period) {
        this.plant_period = plant_period;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getHarvest_period() {
        return harvest_period;
    }

    public void setHarvest_period(String harvest_period) {
        this.harvest_period = harvest_period;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
