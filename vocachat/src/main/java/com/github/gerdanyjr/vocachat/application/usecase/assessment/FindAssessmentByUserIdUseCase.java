package com.github.gerdanyjr.vocachat.application.usecase.assessment;

import com.github.gerdanyjr.vocachat.application.dto.out.assessment.AssessmentResponse;
import com.github.gerdanyjr.vocachat.application.mapper.assessment.IAssessmentMapper;
import com.github.gerdanyjr.vocachat.application.repository.assessment.IAssessmentRepository;
import com.github.gerdanyjr.vocachat.core.exception.impl.user.UserNotFoundException;
import com.github.gerdanyjr.vocachat.core.model.Assessment;

public class FindAssessmentByUserIdUseCase {
    private final IAssessmentRepository IAssessmentRepository;
    private final IAssessmentMapper IAssessmentMapper;

    public FindAssessmentByUserIdUseCase(
            IAssessmentRepository IAssessmentRepository,
            IAssessmentMapper IAssessmentMapper
    ) {
        this.IAssessmentRepository = IAssessmentRepository;
        this.IAssessmentMapper = IAssessmentMapper;
    }

    public AssessmentResponse execute(Long userId) {
        Assessment foundAssesment = IAssessmentRepository
                .findByUserId(userId)
                .orElseThrow(UserNotFoundException::new);

        return IAssessmentMapper.fromAssessmentToAssessmentResponse(foundAssesment);
    }
}
