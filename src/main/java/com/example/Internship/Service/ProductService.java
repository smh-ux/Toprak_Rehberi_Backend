package com.example.Internship.Service;

import com.example.Internship.Entity.Product;
import com.example.Internship.Repository.ProductRepository;
import com.example.Internship.Request.EvaluationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByLand(Long landId) {
        return productRepository.findByLandId(landId);
    }

    public void saveEvaluations(EvaluationRequest request) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Good", 95);
        scores.put("Normal", 50);
        scores.put("Bad", 5);

        Map<String, List<Integer>> productScores = new HashMap<>();

        for (Map.Entry<String, EvaluationRequest.EvaluationDetail> entry : request.getEvaluations().entrySet()) {
            String productName = entry.getKey();
            EvaluationRequest.EvaluationDetail evaluationDetail = entry.getValue();
            String evaluation = evaluationDetail.getEvaluation();
            Integer score = scores.getOrDefault(evaluation, 0);

            productScores.computeIfAbsent(productName, k -> new ArrayList<>()).add(score);
        }

        for (Map.Entry<String, List<Integer>> entry : productScores.entrySet()) {
            String productName = entry.getKey();
            List<Integer> scoresList = entry.getValue();
            double average = scoresList.stream().mapToInt(Integer::intValue).average().orElse(0.0);

//            // Save average to the database
//            productRepository.updateProductEvaluation(productName, average);
        }
    }
}
