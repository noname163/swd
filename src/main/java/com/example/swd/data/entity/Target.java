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

@Entity
@Table(name="Targets")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Target {
    @Id
    @SequenceGenerator(name = "target_sequence", sequenceName = "target_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "target_sequence")
    private Long id;

    @Column(name = "grade", nullable = true, unique = false, length = 100)
    private Double grade;

    @Column(name = "process", nullable = true, unique = false, length = 100)
    private Double process;

    @Column(name = "group_major", nullable = true, unique = false, length = 100)
    private String group;

    @Column(name = "major", nullable = true, unique = false, length = 100)
    private String major;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToMany(mappedBy = "target")
    private List<TargetDetail> targetDetail;
    
}
