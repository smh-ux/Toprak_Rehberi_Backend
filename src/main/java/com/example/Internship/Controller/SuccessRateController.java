package com.example.Internship.Controller;

import com.example.Internship.Request.EvaluationRequest;
import com.example.Internship.Service.SuccessRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/success-rate")
public class SuccessRateController {

    @Autowired
    private SuccessRateService successRateService;

    @PostMapping("/evaluate")
    public ResponseEntity<String> evaluateSuccessRates(@RequestBody EvaluationRequest evaluationRequest) {
        try {
            successRateService.saveEvaluations(evaluationRequest);
            return ResponseEntity.ok("Evaluations saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving evaluations.");
        }
    }
}
