package com.example.Internship.DTO;

public class ProductDTO {
    private Long id;
    private String name;
    private int plantedArea;
    private Long periodId;
    private Long successRateId;
    private Long landId;

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

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public Long getSuccessRateId() {
        return successRateId;
    }

    public void setSuccessRateId(Long successRateId) {
        this.successRateId = successRateId;
    }

    public Long getLandId() {
        return landId;
    }

    public void setLandId(Long landId) {
        this.landId = landId;
    }
}