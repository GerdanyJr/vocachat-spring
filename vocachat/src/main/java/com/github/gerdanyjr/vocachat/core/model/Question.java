package com.github.gerdanyjr.vocachat.core.model;

public class Question {
    private Long questionId;
    private Integer dimension;
    private String questionTxt;

    public Question(Long questionId, Integer dimension, String questionTxt) {
        this.questionId = questionId;
        this.dimension = dimension;
        this.questionTxt = questionTxt;
    }

    public String getQuestionTxt() {
        return questionTxt;
    }

    public void setQuestionTxt(String questionTxt) {
        this.questionTxt = questionTxt;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }
}
