package com.github.gerdanyjr.vocachat.core.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AssessmentScore {
    private Long scoreId;
    private Assessment assessment;
    private BigDecimal score;
    private AssessmentDimension dimension;
    private LocalDateTime calculatedAt;

    public AssessmentScore(
            Long scoreId,
            Assessment assessment,
            BigDecimal score,
            AssessmentDimension dimension,
            LocalDateTime calculatedAt
    ) {
        this.scoreId = scoreId;
        this.assessment = assessment;
        this.score = score;
        this.dimension = dimension;
        this.calculatedAt = calculatedAt;
    }

    public Long getScoreId() {
        return scoreId;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public BigDecimal getScore() {
        return score;
    }

    public AssessmentDimension getDimension() {
        return dimension;
    }

    public LocalDateTime getCalculatedAt() {
        return calculatedAt;
    }
}
