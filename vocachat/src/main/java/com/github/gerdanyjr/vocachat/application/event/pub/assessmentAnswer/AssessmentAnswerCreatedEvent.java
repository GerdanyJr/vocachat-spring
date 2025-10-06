package com.github.gerdanyjr.vocachat.application.event.pub.assessmentAnswer;

import com.github.gerdanyjr.vocachat.application.event.IDomainEvent;

import java.time.LocalDateTime;

public class AssessmentAnswerCreatedEvent implements IDomainEvent {
    private final Long answerId;
    private final String question;
    private final String dimensionName;
    private final String assessmentTypeName;
    private final String answer;

    public AssessmentAnswerCreatedEvent(
            Long answerId,
            String question,
            String dimensionName,
            String assessmentTypeName,
            String answer
    ) {
        this.answerId = answerId;
        this.question = question;
        this.dimensionName = dimensionName;
        this.assessmentTypeName = assessmentTypeName;
        this.answer = answer;
    }

    @Override
    public String getName() {
        return "ASSESSMENT_ANSWER_CREATED";
    }

    @Override
    public LocalDateTime getOccurredAt() {
        return LocalDateTime.now();
    }

    public String getAssessmentTypeName() {
        return assessmentTypeName;
    }

    public String getDimensionName() {
        return dimensionName;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
