package com.github.gerdanyjr.vocachat.application.usecase.assessment;

import com.github.gerdanyjr.vocachat.application.dto.in.assessment.CreateAssessmentRequest;
import com.github.gerdanyjr.vocachat.application.repository.assessment.IAssessmentRepository;
import com.github.gerdanyjr.vocachat.application.repository.user.IUserRepository;
import com.github.gerdanyjr.vocachat.core.builder.assessment.AssessmentBuilder;
import com.github.gerdanyjr.vocachat.core.enums.AssesmentState;
import com.github.gerdanyjr.vocachat.core.exception.impl.user.UserNotFoundException;
import com.github.gerdanyjr.vocachat.core.model.Assessment;
import com.github.gerdanyjr.vocachat.core.model.User;

import java.time.LocalDateTime;

public class CreateAssessmentUseCase {
    private final IAssessmentRepository assessmentRepository;
    private final IUserRepository userRepository;

    public CreateAssessmentUseCase(
            IAssessmentRepository assessmentRepository,
            IUserRepository userRepository
    ) {
        this.assessmentRepository = assessmentRepository;
        this.userRepository = userRepository;
    }

    public Assessment execute(CreateAssessmentRequest request) {
        User foundUser = userRepository
                .findById(request.userId())
                .orElseThrow(UserNotFoundException::new);

        Assessment assessment = new AssessmentBuilder()
                .user(foundUser)
                .startedAt(LocalDateTime.now())
                .assessmentState(AssesmentState.IN_PROGRESS)
                .build();

        return assessmentRepository.create(assessment);
    }
}
