package com.example.Internship.Service;

import com.example.Internship.Entity.Neighborhood;
import com.example.Internship.Entity.SuccessRate;
import com.example.Internship.Repository.NeighborhoodRepository;
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

    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    public List<SuccessRate> getAllSuccessRates() {
        return successRateRepository.findAll();
    }

    public void saveEvaluations(EvaluationRequest request) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Good", 95);
        scores.put("Normal", 50);
        scores.put("Bad", 5);

        for (Map.Entry<String, EvaluationRequest.EvaluationDetail> entry : request.getEvaluations().entrySet()) {
            String successRateName = entry.getKey();
            EvaluationRequest.EvaluationDetail evaluationDetail = entry.getValue();
            String evaluation = evaluationDetail.getEvaluation();
            Long neighborhoodId = evaluationDetail.getNeighborhoodId();

            Integer newScore = scores.getOrDefault(evaluation, 0);

            SuccessRate existingRate = successRateRepository.findByNameAndNeighborhoodId(successRateName, neighborhoodId);

            if (existingRate != null) {
                // Veri alımı
                double currentRate = existingRate.getAverageRate();
                int currentCount = existingRate.getCount();

                double updatedRate = ((currentRate * currentCount) + newScore) / (currentCount + 1);

                int updatedCount = currentCount + 1;

                successRateRepository.updateSuccessRate(successRateName, updatedRate, updatedCount, neighborhoodId);
            } else {
                // Eğer başarı oranı yoksa yeni bir kayıt oluşturuyoruz
                SuccessRate newRate = new SuccessRate();
                newRate.setName(successRateName);
                newRate.setAverageRate(newScore); // İlk değerlendirme olduğu için direkt yeni skoru kaydediyoruz
                newRate.setCount(0); // İlk değerlendirmede sayaç 0 olmalı ki yukarıda 1 ile artırdığımızda ilk grilen değer yarısı olmasın.

                newRate.setNeighborhood(neighborhoodRepository.findById(neighborhoodId)
                        .orElseThrow(() -> new IllegalArgumentException("Mahalle bulunamadı")));
                successRateRepository.save(newRate);
            }
        }
    }

    public List<SuccessRate> getRatesByNeighborhood(Long neighborhoodId) {
        return successRateRepository.findByNeighborhoodId(neighborhoodId);
    }

}