package com.github.gerdanyjr.vocachat.application.usecase.assessmentAnswer;

import com.github.gerdanyjr.vocachat.application.dto.in.assessmentAnswer.CreateAssessmentAnswerRequest;
import com.github.gerdanyjr.vocachat.application.event.pub.IDomainEventPublisher;
import com.github.gerdanyjr.vocachat.application.event.pub.assessmentAnswer.AssessmentAnswerCreatedEvent;
import com.github.gerdanyjr.vocachat.application.repository.assessment.AssessmentRepository;
import com.github.gerdanyjr.vocachat.application.repository.assessmentAnswer.AssessmentAnswerRepository;
import com.github.gerdanyjr.vocachat.application.repository.question.IQuestionRepository;
import com.github.gerdanyjr.vocachat.core.builder.assessmentAnswer.AssessmentAnswerBuilder;
import com.github.gerdanyjr.vocachat.core.enums.AnswerState;
import com.github.gerdanyjr.vocachat.core.exception.impl.assessment.AssessmentNotFoundException;
import com.github.gerdanyjr.vocachat.core.exception.impl.question.QuestionNotFoundException;
import com.github.gerdanyjr.vocachat.core.model.Assessment;
import com.github.gerdanyjr.vocachat.core.model.AssessmentAnswer;
import com.github.gerdanyjr.vocachat.core.model.Question;

public class CreateAssessmentAnswerUseCase {
    private final AssessmentAnswerRepository assessmentAnswerRepository;
    private final AssessmentRepository assessmentRepository;
    private final IQuestionRepository questionRepository;
    private final IDomainEventPublisher domainEventPublisher;

    public CreateAssessmentAnswerUseCase(
            AssessmentAnswerRepository assessmentAnswerRepository,
            AssessmentRepository assessmentRepository,
            IQuestionRepository questionRepository,
            IDomainEventPublisher domainEventPublisher
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
                .answerState(AnswerState.PENDING)
                .build());

        domainEventPublisher.publish(new AssessmentAnswerCreatedEvent(
                assessmentAnswer.getAnswerId(),
                question.getQuestionTxt(),
                createAssessmentAnswerRequest.answer()
        ));
    }
}
