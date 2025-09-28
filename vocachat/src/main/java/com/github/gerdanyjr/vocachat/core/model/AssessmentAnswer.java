package com.github.gerdanyjr.vocachat.core.model;

import com.github.gerdanyjr.vocachat.core.enums.AnswerState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

public class AssessmentAnswer {
    private Long answerId;
    private Assessment assessment;
    private Question question;
    private String answer;
    private AnswerState answerState;
    private BigDecimal compatibilityPercentage;

    public AssessmentAnswer(
            Long answerId,
            Assessment assessment,
            Question question,
            String answer,
            AnswerState answerState,
            BigDecimal compatibilityPercentage
    ) {
        this.answerId = answerId;
        this.assessment = assessment;
        this.question = question;
        this.answer = answer;
        this.answerState = answerState;
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
}
