package com.example.Internship.DTO;

public class PeriodDTO {
    private String name;
    private String plant_start;
    private String plant_end;
    private String harvest_start;
    private String harvest_end;
    private Long product_id;

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

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
}
