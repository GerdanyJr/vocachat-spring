package com.github.gerdanyjr.vocachat.application.event.pub.assessment;

import com.github.gerdanyjr.vocachat.application.event.IDomainEvent;

import java.time.LocalDateTime;

public class AssessmentFinishedEvent implements IDomainEvent {
    private final Long assessmentId;

    public AssessmentFinishedEvent(Long assessmentId) {
        this.assessmentId = assessmentId;
    }

    @Override
    public String getName() {
        return "ASSESSMENT_FINISHED";
    }

    @Override
    public LocalDateTime getOccurredAt() {
        return LocalDateTime.now();
    }

    public Long getAssessmentId() {
        return assessmentId;
    }
}
