package com.github.gerdanyjr.vocachat.core.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AssessmentScore {
    private Long scoreId;
    private Assessment assessment;
    private BigDecimal score;
    private String dimension;
    private LocalDateTime calculatedAt;

    public AssessmentScore(
            Long scoreId,
            Assessment assessment,
            BigDecimal score,
            String dimension,
            LocalDateTime calculatedAt
    ) {
        this.scoreId = scoreId;
        this.assessment = assessment;
        this.score = score;
        this.dimension = dimension;
        this.calculatedAt = calculatedAt;
    }
}
