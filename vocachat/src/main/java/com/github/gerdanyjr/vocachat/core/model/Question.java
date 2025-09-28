package com.github.gerdanyjr.vocachat.core.model;

public class Question {
    private Long questionId;
    private Integer dimension;

    public Question(Long questionId, Integer dimension) {
        this.questionId = questionId;
        this.dimension = dimension;
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
