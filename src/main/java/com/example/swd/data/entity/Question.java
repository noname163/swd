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
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Questions")
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @SequenceGenerator(name = "question_sequence", sequenceName = "question_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "question_sequence")
    private Long id;

    @Column(name = "question", nullable = true, unique = true, length = 100)
    private String question;

    @Column(name = "subject", nullable = true, unique = true, length = 100)
    private String subject;

    @Column(name = "answer", nullable = true, unique = true, length = 100)
    private String answer;

    @ManyToMany
    @JoinTable(name ="question_test",
    joinColumns =  @JoinColumn(name = "question_id"),
    inverseJoinColumns = @JoinColumn(name = "test_id"))
    private List<Test> test;

    @OneToMany(mappedBy = "question")
    private List<WrongAnswer> wrongAnswer;
}
