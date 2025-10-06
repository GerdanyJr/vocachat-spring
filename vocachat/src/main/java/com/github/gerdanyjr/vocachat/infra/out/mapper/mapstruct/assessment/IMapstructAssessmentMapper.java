package com.github.gerdanyjr.vocachat.infra.out.mapper.mapstruct.assessment;

import com.github.gerdanyjr.vocachat.application.dto.out.assessment.AssessmentResponse;
import com.github.gerdanyjr.vocachat.core.enums.AssessmentState;
import com.github.gerdanyjr.vocachat.core.model.Assessment;
import com.github.gerdanyjr.vocachat.infra.out.entity.AssessmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface IMapstructAssessmentMapper {

    @Mapping(source = "user.userId", target = "userId")
    @Mapping(source = "assessmentType.assessmentTypeId", target = "assessmentTypeId")
    @Mapping(source = "assessmentState", target = "assessmentState", qualifiedByName = "fromAssessmentStateToValue")
    @Mapping(target = "answers", ignore = true)
    AssessmentResponse fromAssessmentToAssessmentResponse(Assessment assessment);

    @Mapping(source = "assessmentState", target = "assessmentState", qualifiedByName = "fromAssessmentStateToValue")
    AssessmentEntity fromModelToEntity(Assessment assessment);

    @Mapping(source = "assessmentState", target = "assessmentState", qualifiedByName = "fromValueToAssessmentState")
    @Mapping(target = "answers", ignore = true)
    Assessment fromEntityToModel(AssessmentEntity assessmentEntity);

    @Named("fromValueToAssessmentState")
    default AssessmentState fromValueToAssessmentState(Integer value) {
        return AssessmentState.fromValue(value);
    }

    @Named("fromAssessmentStateToValue")
    default Integer fromAssessmentStateToValue(AssessmentState assessmentState) {
        return assessmentState.getValue();
    }
}

