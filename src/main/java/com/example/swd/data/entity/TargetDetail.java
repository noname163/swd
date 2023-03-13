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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Target_Detail")
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TargetDetail {
    @Id
    @SequenceGenerator(name = "target_detail_sequence", sequenceName = "target_detail_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "target_detail_sequence")
    private long id;

    @Column(name = "grade", nullable = true, unique = false, length = 100)
    private Double grade;

    @Column(name = "process", nullable = true, unique = false, length = 100)
    private Double process;

    @Column(name = "subject", nullable = true, unique = false, length = 100)
    private String subject;

    @Column(name = "major", nullable = true, unique = false, length = 100)
    private String major;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "target_id")
    private Target target;
}
