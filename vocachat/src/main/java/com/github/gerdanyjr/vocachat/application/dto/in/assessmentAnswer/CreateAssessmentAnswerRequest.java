package com.github.gerdanyjr.vocachat.application.dto.in.assessmentAnswer;

public record CreateAssessmentAnswerRequest(
        Long assessmentId,
        Long questionId,
        String answer
) {
}
