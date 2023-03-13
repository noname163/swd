package com.example.swd.service.process.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swd.data.entity.Target;
import com.example.swd.data.entity.TargetDetail;
import com.example.swd.data.entity.TestResult;
import com.example.swd.data.entity.User;
import com.example.swd.data.repositories.TestResultRepository;
import com.example.swd.service.process.ProcessService;
import com.example.swd.data.repositories.*;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private TargetDetailRepository targetDetailRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TargetRepository targetRepository;
    @Autowired
    private TestResultRepository testResultRepository;

    @Override
    public Double caculatedProcessDetail(User user, String testSubject) {
        Optional<TargetDetail> targetDetailOtp = targetDetailRepository.findByUserAndSubject(user, testSubject);
        List<TestResult> testResults = testResultRepository.findBySubjectAndUser(testSubject, user);
        Double averageGrade = 0.0;
        Double newProcess = 0.0;
        for (TestResult testResult : testResults) {
            averageGrade += testResult.getGrade();
        }
        averageGrade = averageGrade / testResults.size();
        newProcess = (averageGrade / targetDetailOtp.get().getGrade()) * 100;
        targetDetailOtp.get().setProcess(newProcess);
        targetDetailRepository.save(targetDetailOtp.get());
        return newProcess;
    }

}
