package com.github.gerdanyjr.vocachat.application.mapper.assessment;

import com.github.gerdanyjr.vocachat.application.dto.out.assessment.AssessmentResponse;
import com.github.gerdanyjr.vocachat.core.model.Assessment;

public interface IAssessmentMapper {
    AssessmentResponse fromAssessmentToAssessmentResponse(Assessment assessment);
}
