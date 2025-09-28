package com.github.gerdanyjr.vocachat.core.builder.assessmentAnswer;

import com.github.gerdanyjr.vocachat.core.enums.AnswerState;
import com.github.gerdanyjr.vocachat.core.model.Assessment;
import com.github.gerdanyjr.vocachat.core.model.AssessmentAnswer;
import com.github.gerdanyjr.vocachat.core.model.Question;

import java.math.BigDecimal;

public class AssessmentAnswerBuilder {
    private Long answerId;
    private Assessment assessment;
    private Question question;
    private String answer;
    private AnswerState answerState;
    private BigDecimal compatibilityPercentage;

    public AssessmentAnswer build() {
        return new AssessmentAnswer(
                answerId,
                assessment,
                question,
                answer,
                answerState,
                compatibilityPercentage
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

    public AssessmentAnswerBuilder answer(String answer) {
        this.answer = answer;
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
}
