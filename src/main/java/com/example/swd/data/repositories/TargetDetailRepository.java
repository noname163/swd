package com.example.swd.data.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swd.data.entity.TargetDetail;

@Repository
public interface TargetDetailRepository extends JpaRepository<TargetDetail, Long> {
    
}
