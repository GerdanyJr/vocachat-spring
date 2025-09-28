package com.github.gerdanyjr.vocachat.core.builder.assessment;

import com.github.gerdanyjr.vocachat.core.enums.AssesmentState;
import com.github.gerdanyjr.vocachat.core.model.Assessment;
import com.github.gerdanyjr.vocachat.core.model.AssessmentAnswer;
import com.github.gerdanyjr.vocachat.core.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AssessmentBuilder {
    private Long assessmentId;
    private User user;
    private Integer testType;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;
    private AssesmentState assessmentState;
    private List<AssessmentAnswer> answers = new ArrayList<>();

    public Assessment build() {
        return new Assessment(
                assessmentId,
                user,
                testType,
                startedAt,
                finishedAt,
                assessmentState,
                answers
        );
    }

    public AssessmentBuilder assessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
        return this;
    }

    public AssessmentBuilder user(User user) {
        this.user = user;
        return this;
    }

    public AssessmentBuilder testType(Integer testType) {
        this.testType = testType;
        return this;
    }

    public AssessmentBuilder startedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    public AssessmentBuilder finishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
        return this;
    }

    public AssessmentBuilder assessmentState(AssesmentState assessmentState) {
        this.assessmentState = assessmentState;
        return this;
    }

    public AssessmentBuilder answers(List<AssessmentAnswer> answers) {
        this.answers = answers;
        return this;
    }

    public AssessmentBuilder addAnswer(AssessmentAnswer answer) {
        this.answers.add(answer);
        return this;
    }
}
