package com.github.gerdanyjr.vocachat.application.usecase.assessment;

import com.github.gerdanyjr.vocachat.application.event.pub.IDomainEventPublisher;
import com.github.gerdanyjr.vocachat.application.event.pub.assessment.AssessmentFinishedEvent;
import com.github.gerdanyjr.vocachat.application.repository.assessment.IAssessmentRepository;
import com.github.gerdanyjr.vocachat.core.enums.AnswerState;
import com.github.gerdanyjr.vocachat.core.enums.AssessmentState;
import com.github.gerdanyjr.vocachat.core.exception.impl.assessment.AssessmentAlreadyFinishedException;
import com.github.gerdanyjr.vocachat.core.exception.impl.assessment.AssessmentNotFoundException;
import com.github.gerdanyjr.vocachat.core.exception.impl.assessment.MinimumAnswersNotMetException;
import com.github.gerdanyjr.vocachat.core.model.Assessment;

public class FinishAssessmentUseCase {
    private final IAssessmentRepository assessmentRepository;
    private final IDomainEventPublisher<AssessmentFinishedEvent> domainEventPublisher;

    public FinishAssessmentUseCase(
            IAssessmentRepository assessmentRepository,
            IDomainEventPublisher<AssessmentFinishedEvent> domainEventPublisher
    ) {
        this.assessmentRepository = assessmentRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    public void execute(Long assessmentId) {
        Assessment foundAssessment = assessmentRepository
                .findById(assessmentId)
                .orElseThrow(AssessmentNotFoundException::new);

        validateAssessment(foundAssessment);

        foundAssessment.finish();
        assessmentRepository.update(foundAssessment);
        boolean allAnswerProcessed = foundAssessment
                .getAnswers()
                .stream()
                .allMatch(a -> a.getAnswerState() == AnswerState.PROCESSED);

        if (allAnswerProcessed) {
            domainEventPublisher.publish(new AssessmentFinishedEvent(assessmentId));
        }
    }

    private void validateAssessment(Assessment assessment) {
        if (assessment.getAnswers().size() < 5) {
            throw new MinimumAnswersNotMetException();
        }
        if (assessment.getAssessmentState() != AssessmentState.CREATED) {
            throw new AssessmentAlreadyFinishedException();
        }
    }
}
