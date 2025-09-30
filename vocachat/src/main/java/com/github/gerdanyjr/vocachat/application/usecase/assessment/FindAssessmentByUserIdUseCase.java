package com.github.gerdanyjr.vocachat.application.usecase.assessment;

import com.github.gerdanyjr.vocachat.application.dto.out.assessment.AssessmentResponse;
import com.github.gerdanyjr.vocachat.application.mapper.assessment.IAssessmentMapper;
import com.github.gerdanyjr.vocachat.application.repository.assessment.IAssessmentRepository;
import com.github.gerdanyjr.vocachat.core.exception.impl.user.UserNotFoundException;
import com.github.gerdanyjr.vocachat.core.model.Assessment;

public class FindAssessmentByUserIdUseCase {
    private final IAssessmentRepository assessmentRepository;
    private final IAssessmentMapper assessmentMapper;

    public FindAssessmentByUserIdUseCase(
            IAssessmentRepository assessmentRepository,
            IAssessmentMapper assessmentMapper
    ) {
        this.assessmentRepository = assessmentRepository;
        this.assessmentMapper = assessmentMapper;
    }

    public AssessmentResponse execute(Long userId) {
        Assessment foundAssesment = assessmentRepository
                .findByUserId(userId)
                .orElseThrow(UserNotFoundException::new);

        return assessmentMapper.fromAssessmentToAssessmentResponse(foundAssesment);
    }
}
