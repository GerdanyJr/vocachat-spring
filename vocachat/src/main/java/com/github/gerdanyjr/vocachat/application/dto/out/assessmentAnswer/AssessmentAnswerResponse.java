package com.github.gerdanyjr.vocachat.application.dto.out.assessmentAnswer;

import com.github.gerdanyjr.vocachat.core.enums.AnswerState;

import java.math.BigDecimal;

public record AssessmentAnswerResponse(
        Long answerId,
        Integer assessmentId,
        Integer questionId,
        String answer,
        AnswerState answerState,
        BigDecimal compatibilityPercentage
) {
}
