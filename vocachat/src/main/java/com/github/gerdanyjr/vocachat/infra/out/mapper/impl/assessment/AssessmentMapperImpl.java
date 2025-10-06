package com.github.gerdanyjr.vocachat.infra.out.mapper.impl.assessment;

import com.github.gerdanyjr.vocachat.application.dto.out.assessment.AssessmentResponse;
import com.github.gerdanyjr.vocachat.application.mapper.assessment.IAssessmentMapper;
import com.github.gerdanyjr.vocachat.core.model.Assessment;
import com.github.gerdanyjr.vocachat.infra.out.entity.AssessmentEntity;
import com.github.gerdanyjr.vocachat.infra.out.mapper.mapstruct.assessment.IMapstructAssessmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AssessmentMapperImpl implements IAssessmentMapper {
    private final IMapstructAssessmentMapper mapper;

    @Override
    public AssessmentResponse fromAssessmentToAssessmentResponse(Assessment assessment) {
        return mapper.fromAssessmentToAssessmentResponse(assessment);
    }

    public AssessmentEntity fromModelToEntity(Assessment assessment) {
        return mapper.fromModelToEntity(assessment);
    }
}
