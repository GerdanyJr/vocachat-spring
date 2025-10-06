package com.github.gerdanyjr.vocachat.infra.out.config;

import com.github.gerdanyjr.vocachat.application.mapper.assessment.IAssessmentMapper;
import com.github.gerdanyjr.vocachat.application.usecase.assessment.CreateAssessmentUseCase;
import com.github.gerdanyjr.vocachat.application.usecase.assessment.FindAssessmentByUserIdUseCase;
import com.github.gerdanyjr.vocachat.application.usecase.assessment.FinishAssessmentUseCase;
import com.github.gerdanyjr.vocachat.infra.out.event.pub.assessment.FinishedAssessmentEventPublisher;
import com.github.gerdanyjr.vocachat.infra.out.repository.impl.assessment.AssessmentRepositoryImpl;
import com.github.gerdanyjr.vocachat.infra.out.repository.impl.user.UserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssessmentBeansConfig {

    @Bean
    public CreateAssessmentUseCase createAssessmentUseCase(
            AssessmentRepositoryImpl assessmentRepository,
            UserRepositoryImpl userRepository
    ) {
        return new CreateAssessmentUseCase(assessmentRepository, userRepository);
    }

    @Bean
    public FindAssessmentByUserIdUseCase findAssessmentByUserIdUseCase(
            AssessmentRepositoryImpl assessmentRepository,
            IAssessmentMapper assessmentMapper
    ) {
        return new FindAssessmentByUserIdUseCase(assessmentRepository, assessmentMapper);
    }

    @Bean
    public FinishAssessmentUseCase finishAssessmentUseCase(
            AssessmentRepositoryImpl assessmentRepository,
            FinishedAssessmentEventPublisher domainEventPublisher
    ) {
        return new FinishAssessmentUseCase(assessmentRepository, domainEventPublisher);
    }
}
