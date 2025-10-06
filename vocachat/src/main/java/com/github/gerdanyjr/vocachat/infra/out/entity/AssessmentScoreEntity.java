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
@Table(name = "assessment_score", uniqueConstraints = @UniqueConstraint(columnNames = {"assessment_id", "dimension_id"}))
public class AssessmentScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scoreId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assessment_id")
    private AssessmentEntity assessmentEntity;

    @Column(name = "score", nullable = false, precision = 5, scale = 2)
    private BigDecimal score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dimension_id", nullable = false)
    private AssessmentDimensionEntity dimension;

    @Column(name = "calculated_at", nullable = false)
    private LocalDateTime calculatedAt;
}
