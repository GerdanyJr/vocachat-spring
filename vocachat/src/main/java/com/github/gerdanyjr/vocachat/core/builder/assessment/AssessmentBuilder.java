package com.github.gerdanyjr.vocachat.core.builder.assessment;

import com.github.gerdanyjr.vocachat.core.enums.AssessmentState;
import com.github.gerdanyjr.vocachat.core.model.Assessment;
import com.github.gerdanyjr.vocachat.core.model.AssessmentAnswer;
import com.github.gerdanyjr.vocachat.core.model.AssessmentType;
import com.github.gerdanyjr.vocachat.core.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AssessmentBuilder {
    private Long assessmentId;
    private User user;
    private AssessmentType assessmentType;
    private LocalDateTime startedAt;
    private LocalDateTime processedAt;
    private LocalDateTime finishedAt;
    private AssessmentState assessmentState;
    private List<AssessmentAnswer> answers = new ArrayList<>();

    public Assessment build() {
        return new Assessment(
                assessmentId,
                user,
                assessmentType,
                startedAt,
                processedAt,
                finishedAt,
                assessmentState,
                answers
        );
    }

    public AssessmentBuilder assessmentType(AssessmentType assessmentType) {
        this.assessmentType = assessmentType;
        return this;
    }

    public AssessmentBuilder assessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
        return this;
    }

    public AssessmentBuilder user(User user) {
        this.user = user;
        return this;
    }

    public AssessmentBuilder startedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    public AssessmentBuilder processedAt(LocalDateTime processedAt) {
        this.processedAt = processedAt;
        return this;
    }

    public AssessmentBuilder finishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
        return this;
    }

    public AssessmentBuilder assessmentState(AssessmentState assessmentState) {
        this.assessmentState = assessmentState;
        return this;
    }

    public AssessmentBuilder answers(List<AssessmentAnswer> answers) {
        this.answers = answers;
        return this;
    }


}
