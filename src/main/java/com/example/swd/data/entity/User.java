package com.example.swd.data.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Users")
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_sequence")
    private Long id;

    @Column(name = "email", nullable = true, unique = true, length = 100)
    private String email;

    @Column(name = "username", nullable = true, unique = true, length = 100)
    private String username;

    @Column(name = "password", nullable = true, unique = true, length = 100)
    private String password;

    @Column(name = "course", nullable = true, unique = true, length = 100)
    private Integer course;

    @OneToMany(mappedBy = "user")
    private List<TestResult> testResult;

    @OneToMany(mappedBy = "user")
    private List<Target> target;
}
