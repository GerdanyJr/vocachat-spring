package com.github.gerdanyjr.vocachat.infra.out.mapper.impl.assessmentAnswer;

import com.github.gerdanyjr.vocachat.application.dto.out.assessmentAnswer.AssessmentAnswerResponse;
import com.github.gerdanyjr.vocachat.application.mapper.assessmentAnswer.IAssessmentAnswerMapper;
import com.github.gerdanyjr.vocachat.core.model.AssessmentAnswer;
import com.github.gerdanyjr.vocachat.infra.out.mapper.mapstruct.assessmentAnswer.IMapstructAssessmentAnswerMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AssessmentAnswerMapperImpl implements IAssessmentAnswerMapper {
    private final IMapstructAssessmentAnswerMapper mapper;

    @Override
    public AssessmentAnswerResponse fromAssessmentAnswerToReponse(AssessmentAnswer answer) {
        return mapper.fromAssessmentAnswerToReponse(answer);
    }
}
