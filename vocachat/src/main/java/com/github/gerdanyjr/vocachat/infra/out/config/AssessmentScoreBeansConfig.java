package com.github.gerdanyjr.vocachat.infra.out.config;

import com.github.gerdanyjr.vocachat.application.usecase.assessmentScore.CalculateAssessmentScoreUseCase;
import com.github.gerdanyjr.vocachat.infra.out.repository.impl.assessment.AssessmentRepositoryImpl;
import com.github.gerdanyjr.vocachat.infra.out.repository.impl.assessmentScore.AssessmentScoreRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class AssessmentScoreBeansConfig {
    @Bean
    public CalculateAssessmentScoreUseCase calculateAssessmentScoreUseCase(
            AssessmentScoreRepositoryImpl assessmentScoreRepository,
            AssessmentRepositoryImpl assessmentRepository
    ) {
        return new CalculateAssessmentScoreUseCase(assessmentScoreRepository, assessmentRepository);
    }
}
