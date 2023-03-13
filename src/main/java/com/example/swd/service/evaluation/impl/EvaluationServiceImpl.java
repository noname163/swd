package com.example.swd.service.evaluation.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swd.data.entity.Test;
import com.example.swd.data.entity.TestResult;
import com.example.swd.data.entity.User;
import com.example.swd.data.repositories.TestRepository;
import com.example.swd.data.repositories.TestResultRepository;
import com.example.swd.data.repositories.UserRepository;
import com.example.swd.service.evaluation.EvaluationService;
import com.example.swd.service.process.ProcessService;
import com.example.swd.service.recommendation.RecommendationService;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private ProcessService processService;
    @Autowired
    private RecommendationService recommendationService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private TestResultRepository testResultRepository;

    @Override
    public Double evaluationTest(Long userId, Long testId) {
        Optional<User> userOtp = userRepository.findById(userId);
        Optional<Test> testOtp = testRepository.findById(testId);
        Test test = testOtp.get();
        User user = userOtp.get();
        TestResult testResult = TestResult.builder()
                .subject(test.getSubject())
                .user(user)
                .test(test)
                .grade(7.0)
                .build();
        testResultRepository.save(testResult);
        Double process = processService.caculatedProcessDetail(user, test.getSubject());
        recommendationService.generateRecommendations(user);
        return process;
    }

}
