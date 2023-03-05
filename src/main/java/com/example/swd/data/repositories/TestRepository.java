package com.example.swd.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swd.data.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    
}
