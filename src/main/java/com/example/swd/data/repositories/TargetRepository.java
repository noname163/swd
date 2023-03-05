package com.example.swd.data.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swd.data.entity.Target;

@Repository
public interface TargetRepository extends JpaRepository<Target, Long> {
    
}
