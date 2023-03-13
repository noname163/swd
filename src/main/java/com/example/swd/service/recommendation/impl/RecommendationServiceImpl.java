package com.example.swd.service.recommendation.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swd.service.recommendation.RecommendationService;
import com.example.swd.data.repositories.*;
import com.example.swd.data.entity.*;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    
    @Autowired
    private LevelRepository levelRepository; 

    @Override
    public Map<String, String> generateRecommendations(User user){
        Map<String, String> recommendations = new HashMap<>();
        Map<String, Double> targets = new HashMap<>();
        Map<String, Double> testResults = new HashMap<>();
        for(Target target : user.getTarget()){
            for(TargetDetail targetDetail : target.getTargetDetail()){
                targets.put(targetDetail.getSubject(), targetDetail.getGrade());
            }
            for (TestResult testResult : user.getTestResult()) {
                testResults.put(testResult.getTest().getSubject(), testResult.getGrade());
            }
        }
        for (String subjectName : testResults.keySet()) {
            double targetGrade = targets.get(subjectName);
            double preTestGrade = testResults.get(subjectName);
            if (preTestGrade >= targetGrade) {
                recommendations.put(subjectName, "You are already meeting the target grade for this subject.");
            } else {
                int hoursPerDay = calculateHoursPerDay(targetGrade, targetGrade - preTestGrade);
                recommendations.put(subjectName, "Spend " + hoursPerDay + " hours per day on this subject to reach the target grade.");
            }
        }
        System.out.println("Recommendations: " + recommendations);
        return recommendations;
    }

    private int calculateHoursPerDay(Double targetGrade,double gradeGap) {
        Optional<Level> levelOtp = levelRepository.findByTargetGrade(targetGrade);
        Level level = levelOtp.get();
        int minGradeOfLevel = level.getMinGrade();
        int maxGradeOfLevel = level.getMaxGrade();
        int minTimeOfLevel = level.getMinTime();
        int maxTimeOfLevel = level.getMaxTime();
        double totalHours = 0;
        if(gradeGap <= minGradeOfLevel){
            totalHours = maxTimeOfLevel * 10;
        }
        else if(gradeGap==((minGradeOfLevel+maxGradeOfLevel)/2)){
            totalHours = ((maxTimeOfLevel+minTimeOfLevel)/2) *10;
        }
        else if(gradeGap > minGradeOfLevel && gradeGap < maxGradeOfLevel){
            totalHours = minTimeOfLevel * 10;
        }
        int days = (int)totalHours / 3;
        return days;
    }
}
