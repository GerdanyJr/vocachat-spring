package com.github.gerdanyjr.vocachat.core.model;

import com.github.gerdanyjr.vocachat.core.enums.AssesmentState;

import java.time.LocalDateTime;
import java.util.List;

public class Assessment {
    private Long assesmentId;
    private User user;
    private Integer testType;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;
    private AssesmentState assesmentState;
    private List<AssessmentAnswer> answers;

    public Assessment(
            Long assesmentId,
            User user,
            Integer testType,
            LocalDateTime startedAt,
            LocalDateTime finishedAt,
            AssesmentState assesmentState,
            List<AssessmentAnswer> answers
    ) {
        this.assesmentId = assesmentId;
        this.user = user;
        this.testType = testType;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.assesmentState = assesmentState;
        this.answers = answers;
    }

    public Long getAssesmentId() {
        return assesmentId;
    }

    public void setAssesmentId(Long assesmentId) {
        this.assesmentId = assesmentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }

    public AssesmentState getAssesmentState() {
        return assesmentState;
    }

    public void setAssesmentState(AssesmentState assesmentState) {
        this.assesmentState = assesmentState;
    }

    public List<AssessmentAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AssessmentAnswer> answers) {
        this.answers = answers;
    }
}
