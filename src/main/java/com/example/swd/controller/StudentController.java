package com.example.swd.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swd.data.entity.User;
import com.example.swd.service.evaluation.EvaluationService;
import com.example.swd.service.recommendation.RecommendationService;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired 
    private RecommendationService recommendationService;
    @Autowired
    private EvaluationService evaluationService;

    @GetMapping("/evaluation/{userId}/{testId}")
    public ResponseEntity<Double> generateRecommendations(@PathVariable Long userId, @PathVariable Long testId){
        return ResponseEntity.ok(
            evaluationService.evaluationTest(userId, testId)
        );
    }
}
