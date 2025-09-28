package com.github.gerdanyjr.vocachat.application.dto.in.assessmentAnswer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AssessmentAnswerProcessedDTO(
        Long answerId,
        Long assessmentId,
        BigDecimal compatibilityPercentage,
        LocalDateTime processedAt
) {
}
