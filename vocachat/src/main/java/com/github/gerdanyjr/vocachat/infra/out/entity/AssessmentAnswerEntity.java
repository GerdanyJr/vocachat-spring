package com.github.gerdanyjr.vocachat.infra.out.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "assessment_answers")
public class AssessmentAnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessment_answer_id")
    private Long assessmentAnswerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assessment_id")
    private AssessmentEntity assessmentEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private QuestionEntity questionEntity;

    @Column(name = "answer", nullable = false, length = 1000)
    private String answer;

    private Integer answerState;

    private BigDecimal compatibilityPercentage;

}
