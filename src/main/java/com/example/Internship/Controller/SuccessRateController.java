package com.example.Internship.Controller;

import com.example.Internship.Entity.SuccessRate;
import com.example.Internship.Repository.SuccessRateRepository;
import com.example.Internship.Request.EvaluationRequest;
import com.example.Internship.Service.SuccessRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/successrate")
public class SuccessRateController {

    @Autowired
    private SuccessRateService successRateService;

    @Autowired
    private SuccessRateRepository successRateRepository;

    @PostMapping("/evaluate")
    public ResponseEntity<String> evaluateSuccessRates(@RequestBody EvaluationRequest evaluationRequest) {
        try {
            successRateService.saveEvaluations(evaluationRequest);
            return ResponseEntity.ok("Evaluations saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving evaluations.");
        }
    }

    @GetMapping("/byNeighborhood/{neighborhoodId}")
    public ResponseEntity<List<SuccessRate>> getRatesByNeighborhood(@PathVariable Long neighborhoodId) {
        List<SuccessRate> successRates = successRateService.getRatesByNeighborhood(neighborhoodId);
        return ResponseEntity.ok(successRates);
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<SuccessRate>> getAllSR() {
        List<SuccessRate> success = successRateRepository.findAll();
        return new ResponseEntity<>(success, HttpStatus.OK);
    }
}
