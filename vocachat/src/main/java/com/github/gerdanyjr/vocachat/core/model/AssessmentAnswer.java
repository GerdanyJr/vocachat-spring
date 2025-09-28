package com.github.gerdanyjr.vocachat.core.model;

import com.github.gerdanyjr.vocachat.core.enums.AnswerState;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AssessmentAnswer {
    private Long answerId;
    private Assessment assessment;
    private Question question;
    private String answer;
    private AnswerState answerState;
    private BigDecimal compatibilityPercentage;
    private LocalDateTime createdAt;
    private LocalDateTime processedAt;

    public AssessmentAnswer(
            Long answerId,
            Assessment assessment,
            Question question,
            String answer,
            AnswerState answerState,
            BigDecimal compatibilityPercentage,
            LocalDateTime createdAt,
            LocalDateTime processedAt
    ) {
        this.answerId = answerId;
        this.assessment = assessment;
        this.question = question;
        this.answer = answer;
        this.answerState = answerState;
        this.compatibilityPercentage = compatibilityPercentage;
        this.createdAt = createdAt;
        this.processedAt = processedAt;
    }

    public void markAsProcessed(BigDecimal compatibilityPercentage, LocalDateTime processedAt) {
        this.answerState = AnswerState.PROCESSED;
        this.processedAt = processedAt;
        this.compatibilityPercentage = compatibilityPercentage;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public Question getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public AnswerState getAnswerState() {
        return answerState;
    }

    public BigDecimal getCompatibilityPercentage() {
        return compatibilityPercentage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getProcessedAt() {
        return processedAt;
    }
}
