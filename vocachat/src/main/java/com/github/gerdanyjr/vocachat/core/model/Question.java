package com.github.gerdanyjr.vocachat.core.model;

public class Question {
    private Long questionId;
    private AssessmentDimension dimension;
    private String questionTxt;

    public Question(Long questionId, AssessmentDimension dimension, String questionTxt) {
        this.questionId = questionId;
        this.dimension = dimension;
        this.questionTxt = questionTxt;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public AssessmentDimension getDimension() {
        return dimension;
    }

    public String getQuestionTxt() {
        return questionTxt;
    }
}
