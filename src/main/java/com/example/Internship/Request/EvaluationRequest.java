package com.example.Internship.Request;

import java.util.Map;

//public class EvaluationRequest {
//    private Long landId;
//
//    private Map<String, String> evaluations;
//
//    public Long getLandId() {
//        return landId;
//    }
//
//    public void setLandId(Long landId) {
//        this.landId = landId;
//    }
//
//    public Map<String, String> getEvaluations() {
//        return evaluations;
//    }
//
//    public void setEvaluations(Map<String, String> evaluations) {
//        this.evaluations = evaluations;
//    }
//}

//public class EvaluationRequest {
//    private Map<String, EvaluationDetail> evaluations; // Her başarı oranı için değerlendirme detayları
//
//    // Getter ve Setter metodları
//    public Map<String, EvaluationDetail> getEvaluations() {
//        return evaluations;
//    }
//
//    public void setEvaluations(Map<String, EvaluationDetail> evaluations) {
//        this.evaluations = evaluations;
//    }
//
//    public static class EvaluationDetail {
//
//        public EvaluationDetail() {
//
//        }
//        private String evaluation;
//        private Long neighborhoodId;
//
//        // Getter ve Setter metodları
//        public String getEvaluation() {
//            return evaluation;
//        }
//
//        public void setEvaluation(String evaluation) {
//            this.evaluation = evaluation;
//        }
//
//        public Long getNeighborhoodId() {
//            return neighborhoodId;
//        }
//
//        public void setNeighborhoodId(Long neighborhoodId) {
//            this.neighborhoodId = neighborhoodId;
//        }
//    }
//}

public class EvaluationRequest {
    private Map<String, EvaluationDetail> evaluations; // Her başarı oranı için değerlendirme detayları

    // Getter ve Setter metodları
    public Map<String, EvaluationDetail> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(Map<String, EvaluationDetail> evaluations) {
        this.evaluations = evaluations;
    }

    public static class EvaluationDetail {
        private String evaluation;
        private Long neighborhoodId; // Mahalle ID'si

        // Varsayılan yapıcı
        public EvaluationDetail() {
        }

        // Getter ve Setter metodları
        public String getEvaluation() {
            return evaluation;
        }

        public void setEvaluation(String evaluation) {
            this.evaluation = evaluation;
        }

        public Long getNeighborhoodId() {
            return neighborhoodId;
        }

        public void setNeighborhoodId(Long neighborhoodId) {
            this.neighborhoodId = neighborhoodId;
        }
    }
}
