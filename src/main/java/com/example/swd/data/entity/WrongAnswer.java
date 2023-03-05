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

@Table(name="Wrong_Answer")
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WrongAnswer {
    @Id
    @SequenceGenerator(name = "wrong_answer_sequence", sequenceName = "wrong_answer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "wrong_answer_sequence")
    private Long id;

    @Column(name = "wrong_answer", nullable = true, unique = true, length = 100)
    private String wrongAnswer;

    @ManyToOne()
    @JoinColumn(name = "question_id")
    private Question question;
}
