package com.github.gerdanyjr.vocachat.infra.out.mapper.mapstruct.assessmentScore;

import com.github.gerdanyjr.vocachat.core.model.AssessmentScore;
import com.github.gerdanyjr.vocachat.infra.out.entity.AssessmentScoreEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMapstructAssessmentScoreMapper {

    AssessmentScore fromEntityToModel(AssessmentScoreEntity assessmentScoreEntity);

    AssessmentScoreEntity fromModelToEntity(AssessmentScore assessmentScore);
}
