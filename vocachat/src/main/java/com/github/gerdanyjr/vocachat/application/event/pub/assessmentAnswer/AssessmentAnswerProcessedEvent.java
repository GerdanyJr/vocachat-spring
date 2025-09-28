package com.github.gerdanyjr.vocachat.application.event.pub.assessmentAnswer;

import com.github.gerdanyjr.vocachat.application.event.IDomainEvent;

import java.time.LocalDateTime;

public class AssessmentAnswerProcessedEvent implements IDomainEvent {
    private final Long assessmentId;

    public AssessmentAnswerProcessedEvent(Long assessmentId) {
        this.assessmentId = assessmentId;
    }

    @Override
    public String getName() {
        return "ASSESSMENT_ANSWER_PROCESSED";
    }

    @Override
    public LocalDateTime getOccurredAt() {
        return LocalDateTime.now();
    }

    public Long getAssessmentId() {
        return assessmentId;
    }
}
