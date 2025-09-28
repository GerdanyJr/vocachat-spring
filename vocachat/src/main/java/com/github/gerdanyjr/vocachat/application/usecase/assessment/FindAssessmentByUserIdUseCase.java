package com.github.gerdanyjr.vocachat.application.usecase.assessment;

import com.github.gerdanyjr.vocachat.application.dto.out.assessment.AssessmentResponse;
import com.github.gerdanyjr.vocachat.application.mapper.assessment.AssessmentMapper;
import com.github.gerdanyjr.vocachat.application.repository.assessment.AssessmentRepository;
import com.github.gerdanyjr.vocachat.core.exception.impl.user.UserNotFoundException;
import com.github.gerdanyjr.vocachat.core.model.Assessment;

public class FindAssessmentByUserIdUseCase {
    private final AssessmentRepository assessmentRepository;
    private final AssessmentMapper assessmentMapper;

    public FindAssessmentByUserIdUseCase(
            AssessmentRepository assessmentRepository,
            AssessmentMapper assessmentMapper
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
