package com.example.Internship.DTO;

public class ProductDTO {
    private String name;
    private int plantedArea;
    private Long landId;

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

    public Long getLandId() {
        return landId;
    }

    public void setLandId(Long landId) {
        this.landId = landId;
    }
}