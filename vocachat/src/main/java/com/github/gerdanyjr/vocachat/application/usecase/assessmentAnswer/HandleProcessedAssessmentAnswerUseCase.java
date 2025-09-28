package com.github.gerdanyjr.vocachat.application.usecase.assessmentAnswer;

import com.github.gerdanyjr.vocachat.application.dto.in.assessmentAnswer.AssessmentAnswerProcessedDTO;
import com.github.gerdanyjr.vocachat.application.event.pub.IDomainEventPublisher;
import com.github.gerdanyjr.vocachat.application.event.pub.assessmentAnswer.AssessmentAnswerProcessedEvent;
import com.github.gerdanyjr.vocachat.application.repository.assessment.IAssessmentRepository;
import com.github.gerdanyjr.vocachat.application.repository.assessmentAnswer.IAssessmentAnswerRepository;
import com.github.gerdanyjr.vocachat.core.enums.AssesmentState;
import com.github.gerdanyjr.vocachat.core.exception.impl.assessment.AssessmentNotFoundException;
import com.github.gerdanyjr.vocachat.core.exception.impl.assessmentAnswer.AssessmentAnswerNotFoundException;
import com.github.gerdanyjr.vocachat.core.model.Assessment;
import com.github.gerdanyjr.vocachat.core.model.AssessmentAnswer;

public class HandleProcessedAssessmentAnswerUseCase {
    private final IAssessmentAnswerRepository assessmentAnswerRepository;
    private final IAssessmentRepository assessmentRepository;
    private final IDomainEventPublisher<AssessmentAnswerProcessedEvent> assessmentAnswerProcessedEventPublisher;

    public HandleProcessedAssessmentAnswerUseCase(
            IAssessmentAnswerRepository assessmentAnswerRepository,
            IAssessmentRepository assessmentRepository,
            IDomainEventPublisher<AssessmentAnswerProcessedEvent> assessmentAnswerProcessedEventPublisher
    ) {
        this.assessmentAnswerRepository = assessmentAnswerRepository;
        this.assessmentRepository = assessmentRepository;
        this.assessmentAnswerProcessedEventPublisher = assessmentAnswerProcessedEventPublisher;
    }

    public void execute(AssessmentAnswerProcessedDTO processedAnswerDTO) {
        AssessmentAnswer assessmentAnswer = assessmentAnswerRepository
                .findById(processedAnswerDTO.answerId())
                .orElseThrow(AssessmentAnswerNotFoundException::new);

        Assessment assessment = assessmentRepository
                .findById(processedAnswerDTO.assessmentId())
                .orElseThrow(AssessmentNotFoundException::new);

        if (assessmentAnswer.getProcessedAt() != null) {
            return;
        }

        assessmentAnswer
                .markAsProcessed(processedAnswerDTO.compatibilityPercentage(), processedAnswerDTO.processedAt());

        assessmentAnswerRepository.update(assessmentAnswer);

        if (assessment.getAssesmentState() == AssesmentState.FINISHED) {
            assessmentAnswerProcessedEventPublisher.publish(new AssessmentAnswerProcessedEvent(
                    processedAnswerDTO.assessmentId()
            ));
        }
    }
}
