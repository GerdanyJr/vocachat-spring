package com.github.gerdanyjr.vocachat.application.mapper.assessmentAnswer;

import com.github.gerdanyjr.vocachat.application.dto.out.assessmentAnswer.AssessmentAnswerResponse;
import com.github.gerdanyjr.vocachat.core.model.AssessmentAnswer;

public interface AssessmentAnswerMapper {
    AssessmentAnswerResponse fromAssessmentAnswerToReponse(AssessmentAnswer answer);
}
