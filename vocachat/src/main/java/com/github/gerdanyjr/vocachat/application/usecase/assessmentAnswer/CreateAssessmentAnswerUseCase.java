package com.github.gerdanyjr.vocachat.application.usecase.assessmentAnswer;

import com.github.gerdanyjr.vocachat.application.dto.in.assessmentAnswer.CreateAssessmentAnswerRequest;
import com.github.gerdanyjr.vocachat.application.event.pub.IDomainEventPublisher;
import com.github.gerdanyjr.vocachat.application.event.pub.assessmentAnswer.AssessmentAnswerCreatedEvent;
import com.github.gerdanyjr.vocachat.application.repository.assessment.IAssessmentRepository;
import com.github.gerdanyjr.vocachat.application.repository.assessmentAnswer.IAssessmentAnswerRepository;
import com.github.gerdanyjr.vocachat.application.repository.message.IMessageRepository;
import com.github.gerdanyjr.vocachat.application.repository.question.IQuestionRepository;
import com.github.gerdanyjr.vocachat.core.builder.assessmentAnswer.AssessmentAnswerBuilder;
import com.github.gerdanyjr.vocachat.core.builder.message.MessageBuilder;
import com.github.gerdanyjr.vocachat.core.enums.AnswerState;
import com.github.gerdanyjr.vocachat.core.enums.MessageSender;
import com.github.gerdanyjr.vocachat.core.exception.impl.assessment.AssessmentNotFoundException;
import com.github.gerdanyjr.vocachat.core.exception.impl.question.QuestionNotFoundException;
import com.github.gerdanyjr.vocachat.core.model.Assessment;
import com.github.gerdanyjr.vocachat.core.model.AssessmentAnswer;
import com.github.gerdanyjr.vocachat.core.model.Message;
import com.github.gerdanyjr.vocachat.core.model.Question;

import java.time.LocalDateTime;

public class CreateAssessmentAnswerUseCase {
    private final IAssessmentAnswerRepository assessmentAnswerRepository;
    private final IAssessmentRepository assessmentRepository;
    private final IQuestionRepository questionRepository;
    private final IMessageRepository messageRepository;
    private final IDomainEventPublisher<AssessmentAnswerCreatedEvent> domainEventPublisher;

    public CreateAssessmentAnswerUseCase(
            IAssessmentAnswerRepository assessmentAnswerRepository,
            IAssessmentRepository assessmentRepository,
            IQuestionRepository questionRepository,
            IMessageRepository messageRepository,
            IDomainEventPublisher<AssessmentAnswerCreatedEvent> domainEventPublisher
    ) {
        this.assessmentAnswerRepository = assessmentAnswerRepository;
        this.assessmentRepository = assessmentRepository;
        this.questionRepository = questionRepository;
        this.messageRepository = messageRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    public void execute(CreateAssessmentAnswerRequest createAssessmentAnswerRequest) {
        Assessment assessment = assessmentRepository
                .findById(createAssessmentAnswerRequest.assessmentId())
                .orElseThrow(AssessmentNotFoundException::new);

        Question question = questionRepository
                .findById(createAssessmentAnswerRequest.questionId())
                .orElseThrow(QuestionNotFoundException::new);

        Message userMessage = messageRepository.create(new MessageBuilder()
                .assessment(assessment)
                .content(createAssessmentAnswerRequest.answer())
                .sentAt(LocalDateTime.now())
                .sender(MessageSender.USER)
                .build());

        messageRepository.create(new MessageBuilder()
                .assessment(assessment)
                .content(question.getQuestionTxt())
                .sentAt(LocalDateTime.now())
                .sender(MessageSender.SYSTEM)
                .build());

        AssessmentAnswer assessmentAnswer = assessmentAnswerRepository.create(new AssessmentAnswerBuilder()
                .assessment(assessment)
                .question(question)
                .message(userMessage)
                .answerState(AnswerState.CREATED)
                .createdAt(LocalDateTime.now())
                .build());

        domainEventPublisher.publish(new AssessmentAnswerCreatedEvent(
                assessmentAnswer.getAnswerId(),
                question.getQuestionTxt(),
                question.getDimension().getDimensionName(),
                assessment.getAssessmentType().getName(),
                createAssessmentAnswerRequest.answer()
        ));
    }
}
