package com.github.gerdanyjr.vocachat.infra.out.mapper.mapstruct.assessmentAnswer;

import com.github.gerdanyjr.vocachat.application.dto.out.assessmentAnswer.AssessmentAnswerResponse;
import com.github.gerdanyjr.vocachat.core.model.AssessmentAnswer;
import com.github.gerdanyjr.vocachat.infra.out.entity.AssessmentAnswerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMapstructAssessmentAnswerMapper {
    AssessmentAnswerResponse fromAssessmentAnswerToReponse(AssessmentAnswer assessmentAnswer);

    AssessmentAnswerEntity fromModelToEntity(AssessmentAnswer assessmentAnswer);

    AssessmentAnswer fromEntityToModel(AssessmentAnswerEntity assessmentAnswerEntity);
}
