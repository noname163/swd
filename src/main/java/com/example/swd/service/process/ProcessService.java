package com.example.swd.service.process;

import com.example.swd.data.entity.User;
import com.example.swd.data.entity.TestResult;

public interface ProcessService {
    public Double caculatedProcessDetail(User user, String testSubject);
}
