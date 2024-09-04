package com.example.Internship.Service;

import com.example.Internship.Entity.Product;
import com.example.Internship.Entity.SuccessRate;
import com.example.Internship.Repository.ProductRepository;
import com.example.Internship.Repository.SuccessRateRepository;
import com.example.Internship.Request.EvaluationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SuccessRateService {

    @Autowired
    private SuccessRateRepository successRateRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<SuccessRate> getAllSuccessRates() {
        return successRateRepository.findAll();
    }

    public void saveEvaluations(EvaluationRequest request) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Good", 95);
        scores.put("Normal", 50);
        scores.put("Bad", 5);

        Map<String, List<Integer>> successRateScores = new HashMap<>();

        for (Map.Entry<String, String> entry : request.getEvaluations().entrySet()) {
            String successRateName = entry.getKey();
            String evaluation = entry.getValue();
            Integer score = scores.getOrDefault(evaluation, 0);

            successRateScores.computeIfAbsent(successRateName, k -> new ArrayList<>()).add(score);
        }

        for (Map.Entry<String, List<Integer>> entry : successRateScores.entrySet()) {
            String successRateName = entry.getKey();
            List<Integer> scoresList = entry.getValue();
            double average = scoresList.stream().mapToInt(Integer::intValue).average().orElse(0.0);

            // Save average to the database
            successRateRepository.updateSuccessRate(successRateName, average);
        }
    }

//    public calculateAndUpdateSuccessRates(Long landId) {
//        List<Product> products = productRepository.findByLandId(landId);
//
//        if(Product product : products) {
//            List<SuccessRate> rates = successRateRepository.findByProductId(product);
//        }
//    }
}