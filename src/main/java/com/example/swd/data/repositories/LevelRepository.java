package com.example.swd.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.swd.data.entity.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
    // Optional<Level> findByMinGradeLessThanEqualAndMaxGradeGreaterThanEqual(@Param("grade") Double grade);

    @Query("SELECT l FROM Level l WHERE l.minGrade <= :grade AND l.maxGrade >= :grade")
    Optional<Level> findByTargetGrade(@Param("grade") Double grade);

}
