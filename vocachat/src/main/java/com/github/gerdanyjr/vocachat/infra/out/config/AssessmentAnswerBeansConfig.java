package com.github.gerdanyjr.vocachat.infra.out.config;

import com.github.gerdanyjr.vocachat.application.usecase.assessmentAnswer.CreateAssessmentAnswerUseCase;
import com.github.gerdanyjr.vocachat.infra.out.event.pub.assessmentAnswer.AssessmentAnswerCreatedEventPublisher;
import com.github.gerdanyjr.vocachat.infra.out.repository.impl.assessment.AssessmentRepositoryImpl;
import com.github.gerdanyjr.vocachat.infra.out.repository.impl.assessmentAnswer.AssessmentAnswerRepositoryImpl;
import com.github.gerdanyjr.vocachat.infra.out.repository.impl.message.MessageRepositoryImpl;
import com.github.gerdanyjr.vocachat.infra.out.repository.impl.question.QuestionRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssessmentAnswerBeansConfig {

    @Bean
    public CreateAssessmentAnswerUseCase createAssessmentAnswerUseCase(
            AssessmentAnswerRepositoryImpl assessmentAnswerRepository,
            AssessmentRepositoryImpl assessmentRepository,
            QuestionRepositoryImpl questionRepository,
            MessageRepositoryImpl messageRepository,
            AssessmentAnswerCreatedEventPublisher assessmentAnswerCreatedEventPublisher
    ) {
        return new CreateAssessmentAnswerUseCase(
                assessmentAnswerRepository,
                assessmentRepository,
                questionRepository,
                messageRepository,
                assessmentAnswerCreatedEventPublisher
        );
    }
}
