package com.example.swd.data.repositories;

import java.util.*;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swd.data.entity.TargetDetail;
import com.example.swd.data.entity.User;

@Repository
public interface TargetDetailRepository extends JpaRepository<TargetDetail, Long> {
    public Optional<TargetDetail> findByUserAndSubject(User user, String subject);
}
