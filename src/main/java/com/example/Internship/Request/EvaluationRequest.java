package com.example.Internship.Request;

import java.util.Map;

public class EvaluationRequest {
    private Long landId;

    private Map<String, String> evaluations; // productName -> evaluation

    public Long getLandId() {
        return landId;
    }

    public void setLandId(Long landId) {
        this.landId = landId;
    }

    public Map<String, String> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(Map<String, String> evaluations) {
        this.evaluations = evaluations;
    }
}
