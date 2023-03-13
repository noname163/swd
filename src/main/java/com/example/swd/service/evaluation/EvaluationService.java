package com.example.swd.service.evaluation;

import com.example.swd.data.entity.Test;
import com.example.swd.data.entity.User;

public interface EvaluationService {
    public Double evaluationTest(Long userID, Long testId);
}
