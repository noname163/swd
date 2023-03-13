package com.example.swd.data.entity;

import java.time.LocalDate;


import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Tests")
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @Id
    @SequenceGenerator(name = "test_sequence", sequenceName = "test_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "test_sequence")
    private Long id;

    @Column(name = "createDate", nullable = true, unique = false, length = 100)
    private LocalDate createDate;
    @Column(name = "subject", nullable = true, unique = false, length = 100)
    private String subject;

    @ManyToMany(mappedBy = "test")
    private List<Question> question;

    @OneToMany(mappedBy = "test")
    private List<TestResult> testResult;
}
