package com.github.gerdanyjr.vocachat.application.dto.out.assessment;

import com.github.gerdanyjr.vocachat.application.dto.out.assessmentAnswer.AssessmentAnswerResponse;

import java.time.LocalDateTime;
import java.util.List;

public record AssessmentResponse(
        Long assesmentId,
        Integer userId,
        Integer assessmentTypeId,
        LocalDateTime startedAt,
        LocalDateTime finishedAt,
        Integer assessmentState,
        List<AssessmentAnswerResponse> answers
) {
}
