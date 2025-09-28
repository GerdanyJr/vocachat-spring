package com.github.gerdanyjr.vocachat.infra.out.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "assessment_score")
public class AssessmentScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scoreId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assessment_id")
    private AssessmentEntity assessmentEntity;

    @Column(name = "score", nullable = false)
    private BigDecimal score;

    @Column(name = "dimension", length = 20, nullable = false)
    private String dimension;

    @Column(name = "calculated_at", nullable = false)
    private LocalDateTime calculatedAt;
}
