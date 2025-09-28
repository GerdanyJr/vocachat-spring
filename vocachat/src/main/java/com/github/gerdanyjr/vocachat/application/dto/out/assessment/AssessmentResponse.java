package com.github.gerdanyjr.vocachat.application.dto.out.assessment;

import com.github.gerdanyjr.vocachat.application.dto.out.assessmentAnswer.AssessmentAnswerResponse;
import com.github.gerdanyjr.vocachat.core.enums.AssesmentState;

import java.time.LocalDateTime;
import java.util.List;

public record AssessmentResponse(
        Long assesmentId,
        Integer userId,
        Integer testType,
        LocalDateTime startedAt,
        LocalDateTime finishedAt,
        AssesmentState assesmentState,
        List<AssessmentAnswerResponse> answers
) {
}
