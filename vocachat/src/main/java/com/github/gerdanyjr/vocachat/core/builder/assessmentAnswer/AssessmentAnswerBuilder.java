package com.github.gerdanyjr.vocachat.core.builder.assessmentAnswer;

import com.github.gerdanyjr.vocachat.core.enums.AnswerState;
import com.github.gerdanyjr.vocachat.core.model.Assessment;
import com.github.gerdanyjr.vocachat.core.model.AssessmentAnswer;
import com.github.gerdanyjr.vocachat.core.model.Message;
import com.github.gerdanyjr.vocachat.core.model.Question;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AssessmentAnswerBuilder {
    private Long answerId;
    private Assessment assessment;
    private Question question;
    private Message message;
    private AnswerState answerState;
    private BigDecimal compatibilityPercentage;
    private LocalDateTime createdAt;
    private LocalDateTime processedAt;

    public AssessmentAnswer build() {
        return new AssessmentAnswer(
                answerId,
                assessment,
                question,
                message,
                answerState,
                compatibilityPercentage,
                createdAt,
                processedAt
        );
    }

    public AssessmentAnswerBuilder answerId(Long answerId) {
        this.answerId = answerId;
        return this;
    }

    public AssessmentAnswerBuilder assessment(Assessment assessment) {
        this.assessment = assessment;
        return this;
    }

    public AssessmentAnswerBuilder question(Question question) {
        this.question = question;
        return this;
    }

    public AssessmentAnswerBuilder message(Message message) {
        this.message = message;
        return this;
    }

    public AssessmentAnswerBuilder answerState(AnswerState answerState) {
        this.answerState = answerState;
        return this;
    }

    public AssessmentAnswerBuilder compatibilityPercentage(BigDecimal compatibilityPercentage) {
        this.compatibilityPercentage = compatibilityPercentage;
        return this;
    }

    public AssessmentAnswerBuilder createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public AssessmentAnswerBuilder processedAt(LocalDateTime processedAt) {
        this.processedAt = processedAt;
        return this;
    }
}
