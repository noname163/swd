package com.example.swd.data.entity;

import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Test_Result")
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TestResult {
    @Id
    @SequenceGenerator(name = "test_result_sequence", sequenceName = "test_result_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "test_result_sequence")
    private Long id;

    @Column(name = "grade", nullable = true, unique = true, length = 100)
    private Double grade;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne()
    @JoinColumn(name = "test_id")
    private Test test;
}
