package com.github.gerdanyjr.vocachat.core.model;

import com.github.gerdanyjr.vocachat.core.enums.AssessmentState;

import java.time.LocalDateTime;
import java.util.List;

public class Assessment {
    private Long assesmentId;
    private User user;
    private AssessmentType assessmentType;
    private LocalDateTime startedAt;
    private LocalDateTime processedAt;
    private LocalDateTime finishedAt;
    private AssessmentState assessmentState;
    private List<AssessmentAnswer> answers;

    public Assessment(
            Long assesmentId,
            User user,
            AssessmentType assessmentType,
            LocalDateTime startedAt,
            LocalDateTime processedAt,
            LocalDateTime finishedAt,
            AssessmentState assessmentState,
            List<AssessmentAnswer> answers
    ) {
        this.assesmentId = assesmentId;
        this.user = user;
        this.assessmentType = assessmentType;
        this.startedAt = startedAt;
        this.processedAt = processedAt;
        this.finishedAt = finishedAt;
        this.assessmentState = assessmentState;
        this.answers = answers;
    }

    public void finish() {
        this.finishedAt = LocalDateTime.now();
        this.assessmentState = AssessmentState.PROCESSING;
    }

    public void process() {
        this.processedAt = LocalDateTime.now();
        this.assessmentState = AssessmentState.FINISHED;
    }

    public LocalDateTime getProcessedAt() {
        return processedAt;
    }

    public Long getAssesmentId() {
        return assesmentId;
    }

    public User getUser() {
        return user;
    }

    public AssessmentType getAssessmentType() {
        return assessmentType;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public AssessmentState getAssessmentState() {
        return assessmentState;
    }

    public List<AssessmentAnswer> getAnswers() {
        return answers;
    }

}
