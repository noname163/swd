package com.example.swd.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swd.data.entity.TestResult;
import com.example.swd.data.entity.User;
import com.example.swd.data.entity.Test;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {
    List<TestResult> findByTestAndUser(Test test, User user);
    List<TestResult> findBySubjectAndUser(String subject, User user);
}
