package com.github.gerdanyjr.vocachat.core.builder.assessmentScore;

import com.github.gerdanyjr.vocachat.core.model.Assessment;
import com.github.gerdanyjr.vocachat.core.model.AssessmentDimension;
import com.github.gerdanyjr.vocachat.core.model.AssessmentScore;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AssessmentScoreBuilder {
    private Long scoreId;
    private Assessment assessment;
    private BigDecimal score;
    private AssessmentDimension dimension;
    private LocalDateTime calculatedAt;

    public AssessmentScore build() {
        return new AssessmentScore(
                scoreId,
                assessment,
                score,
                dimension,
                calculatedAt
        );
    }

    public AssessmentScoreBuilder scoreId(Long scoreId) {
        this.scoreId = scoreId;
        return this;
    }

    public AssessmentScoreBuilder assessment(Assessment assessment) {
        this.assessment = assessment;
        return this;
    }

    public AssessmentScoreBuilder score(BigDecimal score) {
        this.score = score;
        return this;
    }

    public AssessmentScoreBuilder dimension(AssessmentDimension dimension) {
        this.dimension = dimension;
        return this;
    }

    public AssessmentScoreBuilder calculatedAt(LocalDateTime calculatedAt) {
        this.calculatedAt = calculatedAt;
        return this;
    }
}
