package com.example.Internship.Entity;

import jakarta.persistence.*;

@Entity
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String plant_start;

    @Column(nullable = false)
    private String plant_end;

    @Column(nullable = false)
    private String harvest_start;

    @Column(nullable = false)
    private String harvest_end;

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

    public String getPlant_start() {
        return plant_start;
    }

    public void setPlant_start(String plant_start) {
        this.plant_start = plant_start;
    }

    public String getPlant_end() {
        return plant_end;
    }

    public void setPlant_end(String plant_end) {
        this.plant_end = plant_end;
    }

    public String getHarvest_start() {
        return harvest_start;
    }

    public void setHarvest_start(String harvest_start) {
        this.harvest_start = harvest_start;
    }

    public String getHarvest_end() {
        return harvest_end;
    }

    public void setHarvest_end(String harvest_end) {
        this.harvest_end = harvest_end;
    }
}