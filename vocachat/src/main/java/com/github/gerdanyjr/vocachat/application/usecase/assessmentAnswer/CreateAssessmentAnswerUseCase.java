package com.github.gerdanyjr.vocachat.application.usecase.assessmentAnswer;

import com.github.gerdanyjr.vocachat.application.dto.in.assessmentAnswer.CreateAssessmentAnswerRequest;
import com.github.gerdanyjr.vocachat.application.event.pub.IDomainEventPublisher;
import com.github.gerdanyjr.vocachat.application.event.pub.assessmentAnswer.AssessmentAnswerCreatedEvent;
import com.github.gerdanyjr.vocachat.application.repository.assessment.IAssessmentRepository;
import com.github.gerdanyjr.vocachat.application.repository.assessmentAnswer.IAssessmentAnswerRepository;
import com.github.gerdanyjr.vocachat.application.repository.question.IQuestionRepository;
import com.github.gerdanyjr.vocachat.core.builder.assessmentAnswer.AssessmentAnswerBuilder;
import com.github.gerdanyjr.vocachat.core.enums.AnswerState;
import com.github.gerdanyjr.vocachat.core.exception.impl.assessment.AssessmentNotFoundException;
import com.github.gerdanyjr.vocachat.core.exception.impl.question.QuestionNotFoundException;
import com.github.gerdanyjr.vocachat.core.model.Assessment;
import com.github.gerdanyjr.vocachat.core.model.AssessmentAnswer;
import com.github.gerdanyjr.vocachat.core.model.Question;

import java.time.LocalDateTime;

public class CreateAssessmentAnswerUseCase {
    private final IAssessmentAnswerRepository assessmentAnswerRepository;
    private final IAssessmentRepository assessmentRepository;
    private final IQuestionRepository questionRepository;
    private final IDomainEventPublisher<AssessmentAnswerCreatedEvent> domainEventPublisher;

    public CreateAssessmentAnswerUseCase(
            IAssessmentAnswerRepository assessmentAnswerRepository,
            IAssessmentRepository assessmentRepository,
            IQuestionRepository questionRepository,
            IDomainEventPublisher<AssessmentAnswerCreatedEvent> domainEventPublisher
    ) {
        this.assessmentAnswerRepository = assessmentAnswerRepository;
        this.assessmentRepository = assessmentRepository;
        this.questionRepository = questionRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    public void execute(CreateAssessmentAnswerRequest createAssessmentAnswerRequest) {
        Assessment assessment = assessmentRepository
                .findById(createAssessmentAnswerRequest.assessmentId())
                .orElseThrow(AssessmentNotFoundException::new);

        Question question = questionRepository
                .findById(createAssessmentAnswerRequest.questionId())
                .orElseThrow(QuestionNotFoundException::new);

        AssessmentAnswer assessmentAnswer = assessmentAnswerRepository.create(new AssessmentAnswerBuilder()
                .assessment(assessment)
                .question(question)
                .answer(createAssessmentAnswerRequest.answer())
                .answerState(AnswerState.CREATED)
                .createdAt(LocalDateTime.now())
                .build());

        domainEventPublisher.publish(new AssessmentAnswerCreatedEvent(
                assessmentAnswer.getAnswerId(),
                question.getQuestionTxt(),
                createAssessmentAnswerRequest.answer()
        ));
    }
}
