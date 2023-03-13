package com.example.swd.data.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Levels")
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Level {
    @Id
    @SequenceGenerator(name = "level_sequence", sequenceName = "level_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "level_sequence")
    private Long id;

    @Column(name = "level", unique = false)
    private Integer level;
    @Column(name = "min_grade", unique = false)
    private Integer minGrade;
    @Column(name = "max_grade", unique = false)
    private Integer maxGrade;
    @Column(name = "min_time", unique = false)
    private Integer minTime;
    @Column(name = "max_time", unique = false)
    private Integer maxTime;

}
