package com.github.gerdanyjr.vocachat.core.model;

public class AssessmentType {
    private Integer assessmentTypeId;
    private String name;

    public AssessmentType(Integer assessmentTypeId, String name) {
        this.assessmentTypeId = assessmentTypeId;
        this.name = name;
    }

    public Integer getAssessmentTypeId() {
        return assessmentTypeId;
    }

    public String getName() {
        return name;
    }
}
